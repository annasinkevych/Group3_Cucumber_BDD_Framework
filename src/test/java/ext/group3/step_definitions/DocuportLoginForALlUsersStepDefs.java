package ext.group3.step_definitions;

import ext.group3.pages.docuport.DocuClientPage;
import ext.group3.pages.docuport.DocuLoginPage;
import ext.group3.pages.docuport.DocuportBasePage;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.DocuportConstants;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class DocuportLoginForALlUsersStepDefs {

    DocuLoginPage loginPage = new DocuLoginPage();
    DocuClientPage clientPage = new DocuClientPage();
    DocuportBasePage basePage = new DocuportBasePage();
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    String username = "";

    @When("user enters credentials as {string} {string}")
    public void user_enters_credentials_as(String username, String password) {

        //currently environment is set to beta in the configuration properties
        Driver.getDriver().get(Environment.URL);

        assertTrue(loginPage.loginButton.isDisplayed());
        loginPage.usernameField.sendKeys(username);
        loginPage.passwordField.sendKeys(password);
        loginPage.loginButton.click();

    }

    @Then("user should see the {string} displayed")
    public void user_should_see_the_displayed(String string) {
        boolean actual;
        BrowserUtils.justWait(DocuportConstants.small);

        try {
            actual = basePage.Batch1Group3Button.isDisplayed();
        }catch (NullPointerException e) {
            actual = false;
        }


        softAssertions.assertThat(actual).
                as("Validating button: " + basePage.Batch1Group3Button.getText().
                equals("Batch1 Group3"));
        LOG.info("Expected button: " + basePage.Batch1Group3Button.getText());
    }

}