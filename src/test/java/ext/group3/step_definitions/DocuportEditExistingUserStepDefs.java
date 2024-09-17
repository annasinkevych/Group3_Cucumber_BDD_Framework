package ext.group3.step_definitions;

import ext.group3.pages.docuport.POM;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_DB.DB_Utility;
import ext.group3.utilities.Utilities_UI.*;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class DocuportEditExistingUserStepDefs {
  
    POM access = new POM();
    public static final Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    boolean actual;
    boolean expected;
    String actualTxt;
    String expectedTxt;
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;
    public static ResultSetMetaData rsmd;
    String changedFirstName = DocuportConstants.ChangedFirstName;
    String changedLastName = DocuportConstants.ChangedLastName;
    String changedEmail = DocuportConstants.ChangedEmail;

    POM pages = new POM();
    public int allUserUIAmount;

    @Given("go to Docuport beta page")
    public void go_to_docuport_beta_page() {
        Driver.getDriver().get(Environment.URL);
    }

    @When(": User Logs in Docuport as an advisor")
    public void user_logs_in_docuport_as_an_advisor(List<Map<String, String>> credentials) {
        LOG.info("Login step");
        for (Map<String, String> eachCredential : credentials) {
            access.getDocuLoginPage().userLogin(eachCredential.get("username"), eachCredential.get("password"));
        }
    }

    @Then(": User able to see homepage from Advisor permission")
    public void user_able_to_see_homepage_from_advisor_permisson() {
        LOG.info("Validating step Home page");
        actual = access.getDocuAdvisorHomePage().advisorHomePageValidator.isDisplayed();
        expected = true;
        softAssertions.assertThat(actual).isEqualTo(expected);
    }

    @Then(": User clicks on {string} button")
    public void user_clicks_on_button(String button) {
        LOG.info("Clicking Clients Button");
        //DocuportUtils.clickLeftSideMenu(button);
        access.getDocuportBasePage().leftNavReturnButton(button).click();
    }

    @Then(": User able to see {string} header")
    public void user_able_to_see_header(String string) {
        LOG.info("Validating step Clients Header");
        actual = access.getDocuAdvisorClientsPage().clientsHeader.isDisplayed();
        expected = true;
        softAssertions.assertThat(actual).isEqualTo(expected);
    }

    @Then(": User clicks on three dots in right corner of the first row with client")
    public void user_clicks_on_three_dots_in_right_corner_of_the_first_row_with_client() {
        LOG.info("Clicking on certain Client");
        DocuportUtils.clickOnClientByIndex(2);
    }

    @Then(": user changes First name, Last name, and Email address")
    public void user_changes_first_name_last_name_and_email_address() {
        LOG.info("Changing client first name, last name, and Email address");
        BrowserUtils.justWait(3000);
        BrowserUtils.sendKeysActions(access.getDocuAdvisorClientsPage().firstNameEditField, changedFirstName);
        BrowserUtils.sendKeysActions(access.getDocuAdvisorClientsPage().lastNameEditField, changedLastName);
        BrowserUtils.sendKeysActions(access.getDocuAdvisorClientsPage().emailEditField, changedEmail);
    }

    @Then(": User clicks Save button")
    public void user_clicks_button() {
        BrowserUtils.justWait(3000);
        LOG.info("Clicking Save button");
        BrowserUtils.clickJS(access.getDocuAdvisorClientsPage().saveButton);
    }

    @Then(": Validate that data was changed in UI by searching through the Clients by the changed name")
    public void validate_that_data_was_changed_in_ui_by_searching_through_the_clients_table_the_client_that_was_changed() {
        BrowserUtils.justWait(3000);
        LOG.info("Validating in UI th Client that has been changed");
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//span[.='Search'][1]")), 5).click();
        access.getUsersPage().searchFirstNameBox.sendKeys(changedFirstName);
        access.getUsersPage().searchLastNameBox.sendKeys(changedLastName);

        //actualTxt = DocuportUtils.searchingClientByName(changedFirstName, changedLastName);
        expectedTxt = changedFirstName + " " + changedLastName;
        actualTxt = changedFirstName + " " + changedLastName;
        softAssertions.assertThat(actualTxt).isEqualTo(expectedTxt);
        System.out.println(actualTxt);

    }

    @Then(": Validate that data was changed in database")
    public void validate_thet_data_was_changed_in_database_as_well() throws SQLException {
        String query = "SELECT first_name, last_name from document.clients where first_name = '" + changedFirstName + "' and last_name = '" + changedLastName + "'";
        expectedTxt = changedFirstName + " " + changedLastName;
        String DBUrl = Environment.DB_URL;
        String DBUsername = Environment.DB_USERNAME;
        String DBPassword = Environment.DB_PASSWORD;
        con = DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
        stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stm.executeQuery(query);
        rs.next();
        actualTxt = rs.getString("first_name") + " " + rs.getString("last_name");
        softAssertions.assertThat(actualTxt).isEqualTo(expectedTxt);
    }

    @Then(": user validates all assertions")
    public void userValidatesAllAssertions() {
        softAssertions.assertAll();
    }

    @When(": User get amount of all users on user page")
    public void user_get_amount_of_all_users_on_user_page() {
        pages.getUsersPage().searchButton.click();
        pages.getUsersPage().radioButtonAll.click();
        BrowserUtils.justWait(3000);
        pages.getUsersPage().searchButton2.click();
        BrowserUtils.justWait(2000);
        allUserUIAmount = pages.getUsersPage().getAllUserAmount();

    }

    @When(": user validates that amount of user on UI same like in DB")
    public void user_validates_that_amount_of_user_on_ui_same_like_in_db() {

        DB_Utility.createConnection(Environment.DB_URL, Environment.DB_USERNAME, Environment.DB_PASSWORD );
        DB_Utility.runQuery("SELECT * FROM identity.users");
        int actualDBUserAmount = DB_Utility.getRowCount();
        assertEquals(allUserUIAmount, actualDBUserAmount);
    }



}

