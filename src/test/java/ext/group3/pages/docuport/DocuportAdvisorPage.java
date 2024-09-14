package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportAdvisorPage extends DocuportBasePage {

    public DocuportAdvisorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[contains(.,'Upload documents')])[2]")
    public WebElement uploadDocumentButton;

    @FindBy(xpath = "//section[@class='docu-upload']")
    public WebElement uploadFile;

    @FindBy(xpath = "(//label[.='Client']/following-sibling::input)[1]")
    public WebElement client;
    @FindBy(xpath = "//h3[.='Upload document(s)']")
    public WebElement uploadDocuments;
    @FindBy(xpath = "(//label[.='Service']/following-sibling::input)[1]")
    public WebElement service;
    @FindBy(xpath = "//span[.=' Upload ']")
    public WebElement uploadDocumentsButton;

    @FindBy(xpath = "//span[.='An error occurred. Document(s) could not be uploaded']")
    public WebElement notUpdateMessage;
    @FindBy(xpath = "(//div[.='Danny Banny'])[1]")
    public WebElement choose;
//    @FindBy(xpath = "(//span[.='Danny Banny'])[1]")
//    public WebElement chooses;

    @FindBy(xpath = "(//div[.='Consultancy'])[1]")
    public WebElement serviceOption;

    @FindBy(xpath = "(//span[.=' IRS/State Letter '])[4]")
    public WebElement docType;

    @FindBy(xpath = "(//span[.=' Q4 '])[4]")
    public WebElement q4;
    public static void  clientNameChoose(String clients){

    }

}
