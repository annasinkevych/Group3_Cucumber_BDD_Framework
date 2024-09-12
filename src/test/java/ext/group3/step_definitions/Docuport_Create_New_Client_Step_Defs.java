package ext.group3.step_definitions;

import ext.group3.pages.docuport.POM;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.DocuportConstants;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

public class Docuport_Create_New_Client_Step_Defs {

    POM pages = new POM();
    private SoftAssertions softAssertions = new SoftAssertions();
    private static final Logger LOG = LogManager.getLogger();

    @Given("the user is logged in as an advisor")
    public void the_user_is_logged_in_as_an_advisor() {

        Driver.getDriver().get(Environment.URL);
        pages.getDocuLoginPage().userLogin(DocuportConstants.USERNAME_ADVISOR, DocuportConstants.PASSWORD);
    }
    @When("the user creates a new client with the following details:")
    public void the_user_creates_a_new_client_with_the_following_details(DataTable dataTable) {
        pages.getDocuClientPage().clickOnTabLeftNavMenu("Clients");
        pages.getDocuClientPage().clickOnTabLeftNavMenu("Create new client");
        pages.getDocuClientPage().clickOnTabLeftNavMenu("Personal");



        // Convert the DataTable to a Map
        Map<String, String> clientDetails = dataTable.asMaps(String.class, String.class).get(0);
        BrowserUtils.justWait(3000);
        pages.getDocuEditClientPage().buttonClick("Create new user");
        for (Map.Entry<String, String> entry : clientDetails.entrySet()) {
            pages.getDocuEditClientPage().sendKeysToTxtField(entry.getKey(), entry.getValue());
        }

        pages.getDocuEditClientPage().sendKeysToDropDownContainer("Advisor", "Batch1 Group3");

        BrowserUtils.justWait(3000);
        BrowserUtils.clickWithJS(pages.getDocuEditClientPage().submitButton);
        BrowserUtils.justWait(3000);

        pages.getDocuEditClientPage().sendKeysToDropDownContainer("Advisor", "Batch1 Group3");
        pages.getDocuEditClientPage().sendKeysToDropDownContainer("Services", "Consultancy");
        pages.getDocuEditClientPage().buttonClick("Single");
        BrowserUtils.clickWithJS(pages.getDocuEditClientPage().submitButton);

    }
    @When("the user validates that new client was created {string} and {string}")
    public void the_user_validates_that_new_client_was_created(String name, String lastName) {

        String fullName = name + " " + lastName;
        String actual = pages.getDocuClientPage().getSuccessMessagePopUp(fullName).getText();
        String expected = " has been updated successfully";
        softAssertions.assertThat(actual).isEqualTo(fullName + expected);
    }
    @When("the user logs out as an advisor")
    public void the_user_logs_out_as_an_advisor() {

        pages.getDocuEditClientPage().buttonClick("Batch1 Group3");
        pages.getDocuEditClientPage().buttonClick("Log out");
        softAssertions.assertThat(pages.getDocuLoginPage().loginTextElement.isDisplayed());
    }
    @Then("the user should be able to log in as a new client using:")
    public void the_user_should_be_able_to_log_in_as_a_new_client_using(DataTable dataTable) {

        Map<String, String> loginDetails = dataTable.asMaps(String.class, String.class).get(0);
        pages.getDocuLoginPage().userLogin(loginDetails.get("Email address"), loginDetails.get("Password"));
    }

    @Then("the user name {string} and {string} should be displayed in the top right")
    public void the_user_name_and_should_be_displayed_in_the_top_right(String name, String lastName) {
        String fullName = name + " " + lastName;
        boolean actual;
        try {actual = pages.getDocuClientPage().elementIsDisplayed(fullName).isDisplayed();}
        catch(NullPointerException e){actual = false;}

        boolean expected = true;
        softAssertions.assertThat(actual).as("Validating element: " + fullName).isEqualTo(expected);
        LOG.info("Expected button: {}.", fullName); //18.08.2024 13:30:57 INFO  ClientStepDefs:54 - Expected button: Home

        //asserting all the previous ones
        softAssertions.assertAll();
    }
}
