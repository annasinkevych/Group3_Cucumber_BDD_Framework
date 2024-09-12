package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DocuAdvisorClientsPage {
    DocuAdvisorClientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[.='Clients']")
    public WebElement clientsHeader;

    @FindBy(xpath = "(//div[.=' Edit client ']/..)[3]")
    public WebElement editClientButton;

    @FindBy(xpath = "//label[.='First name']//following-sibling::input")
    public WebElement firstNameEditField;

    @FindBy(xpath = "//label[.='Last name']//following-sibling::input")
    public WebElement lastNameEditField;

    @FindBy(xpath = "//label[.='Email address']//following-sibling::input")
    public WebElement emailEditField;

    @FindBy(xpath = "//span[.=' Save ']/..")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement amountOfRows;

    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-chevron-right theme--light']/../..")
    public WebElement nextPageButton;


}
