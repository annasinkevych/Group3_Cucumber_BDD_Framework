package ext.group3.step_definitions;

import ext.group3.pages.docuport.DocuLeadsPage;
import ext.group3.pages.docuport.DocuLoginPage;
import ext.group3.pages.docuport.DocuportBasePage;
import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.Map;

public class LeadsDetails {

    DocuLoginPage docuLoginPage = new DocuLoginPage();
    DocuportBasePage docuportBasePage = new DocuportBasePage();
    DocuLeadsPage docuLeadPage = new DocuLeadsPage();
    private SoftAssertions softAssertions = new SoftAssertions();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("docuport"));
    }
    @When("user enters credentials")
    public void user_enters_credentials(Map <String, String> credentials) {
        docuLoginPage.userLogin(credentials.get("username"),credentials.get("password") );
    }

    @When("user navigate to {string} page")
    public void user_navigate_to_page(String leadsButton) {
        docuportBasePage.leftNavReturnButton(leadsButton).click();
    }
    @Then("user should see {string} page")
    public void user_should_see_leads_page(String leadsText) {
        String actual = docuportBasePage.getElementTextTagAndName("h1",leadsText);
        String expected = leadsText;
        softAssertions.assertThat(actual).isEqualTo(expected);
        // can not use getElementText because there is few Leads, need to use specific tag to identify exact one
    }
    @When("user clicks on Leads details button")
    public void user_clicks_on_Leads_details_button (){
        docuLeadPage.leadsDetailsPage.click();

    }



}
