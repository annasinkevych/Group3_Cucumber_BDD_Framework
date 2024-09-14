package ext.group3.step_definitions;

import com.github.javafaker.Faker;
import ext.group3.pages.docuport.DocuClientPage;
import ext.group3.pages.docuport.DocuLoginPage;
import ext.group3.pages.docuport.DocuportAdvisorPage;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DocuportUploadDocument {
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();
    DocuLoginPage loginPage = new DocuLoginPage();
    DocuClientPage clientPage = new DocuClientPage();
    DocuportAdvisorPage docuportAdvisorPage = new DocuportAdvisorPage();
    Actions actions = new Actions(Driver.getDriver());
    DocuportAdvisorPage docu = new DocuportAdvisorPage();

    //    String path = "C:/Users/sevar/OneDrive/Escritorio/note.txt";
//    String path = "C:\\Users\\sevar\\Downloads\\DocBeta (1).xlsx";
    String path = "C:/Users/sevar/OneDrive/Escritorio/note.txt";


    @Given("user is on Docuport Login Page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(Environment.URL);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        loginPage.userLogin(Environment.ADVISOR_EMAIL, Environment.ADVISOR_PASSWORD);

    }
/*
    @When("user enters credentials as {string} and {string}")
    public void user_enters_credentials_as_and(String username, String password) {
        softAssertions.assertThat(loginPage.loginButton.isDisplayed());
        loginPage.userLogin(username, password);
    }

 */

    @Then("user clicks on {string} and update a file")
    public void user_clicks_on_and_update_a_file(String button) throws InterruptedException {


        clientPage.clickOnTabLeftNavMenu(button);
        docuportAdvisorPage.uploadDocumentButton.click();
        softAssertions.assertThat(docuportAdvisorPage.uploadFile.isDisplayed());
        softAssertions.assertThat(docuportAdvisorPage.uploadFile.isEnabled());


        // File to be uploaded
        File file = new File("C:/Users/sevar/OneDrive/Escritorio/note.txt");

        // JavaScript to create DataTransfer and simulate drop
        String jsScript = "var target = arguments[0]; " +
                "var dataTransfer = new DataTransfer(); " +
                "var file = new File([new Blob(['file content'], {type: 'text/plain'})], '" + file.getName() + "'); " +
                "dataTransfer.items.add(file); " +
                "target.dispatchEvent(new DragEvent('drop', { dataTransfer: dataTransfer }));";

        // Execute the JavaScript with the drop area element
        ((JavascriptExecutor) Driver.getDriver()).executeScript(jsScript, docuportAdvisorPage.uploadFile);

        //        Faker faker = new Faker();

        assertTrue(docuportAdvisorPage.uploadDocuments.isDisplayed());

        //        docuportAdvisorPage.uploadDocuments.sendKeys(faker.funnyName().name());

        docuportAdvisorPage.client.sendKeys(ConfigurationReader.getProperties("clientname"));

        docuportAdvisorPage.choose.click();
        docuportAdvisorPage.service.sendKeys(ConfigurationReader.getProperties("service"));


        docuportAdvisorPage.service.click();

        docuportAdvisorPage.serviceOption.click();
        BrowserUtils.waitForClickable(docuportAdvisorPage.docType, 10);
        BrowserUtils.justWait(3000);
        docuportAdvisorPage.docType.click();
        BrowserUtils.justWait(3000);
        docuportAdvisorPage.q4.click();
        docuportAdvisorPage.uploadDocumentsButton.click();


    }


    @Then("user verify file was uploaded")
    public void user_verify_file_was_uploaded() {

        String expMessage = "Document(s) have been uploaded successfully";

       assertEquals(docu.successMessage.getText(), expMessage);
    }

}
