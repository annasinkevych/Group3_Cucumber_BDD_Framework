package ext.group3.step_definitions;

import ext.group3.pages.docuport.DocuLoginPage;
import ext.group3.pages.docuport.DocuportBasePage;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.DocuportConstants;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.ElementClickInterceptedException;


import static org.junit.Assert.assertTrue;

public class DocuportLoginForALlUsersStepDefs {

    DocuLoginPage loginPage = new DocuLoginPage();
    DocuportBasePage basePage = new DocuportBasePage();
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    String username = "";

    @When("user enters credentials as {string} {string}")
    public void user_enters_credentials_as(String username, String password) {

        //currently environment is set to beta in the configuration properties
        Driver.getDriver().get(Environment.URL);
        assertTrue(loginPage.loginButton.isDisplayed());
        loginPage.userLogin(username, password);

    }

    @Then("user should see the {string} displayed")
    public void user_should_see_the_displayed(String text) {
        String actual = basePage.getElementText(text);
        BrowserUtils.justWait(DocuportConstants.small);
        String expected = text;
        softAssertions.assertThat(actual).isEqualTo(expected);
        LOG.info("Expected button: " + text);
    }

    @When("user clicks on the usericon button")
    public void user_clicks_on_the_usericon_button() {
        BrowserUtils.waitForVisibility(loginPage.userIcon, 10).click();
    }

    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {

            BrowserUtils.waitForVisibility(loginPage.logoutButton,4).click();
            BrowserUtils.waitForVisibility(loginPage.logoutButton,4).click();

    }

    @Then("user should be successfully logged out and should see the login page displayed")
    public void user_should_be_successfully_logged_out_and_should_see_the_login_page_displayed() {
        loginPage.loginTextElement.isDisplayed();
    }

}

