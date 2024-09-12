package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.security.cert.X509Certificate;

public class UsersPage extends DocuportBasePage{

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersButton;

    @FindBy(xpath = "(//span[.='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[.=' Search ']")
    public WebElement searchButton2;

    @FindBy(xpath = "//label[.='First name']//following-sibling::input")
    public WebElement searchFirstNameBox;


    @FindBy(xpath = "//label[.='Last name']//following-sibling::input")
    public WebElement searchLastNameBox;


    @FindBy(xpath = "//label[.='Email address']//following-sibling::input")
    public WebElement searchEmailAddressBox;


    @FindBy(xpath = "//label[.='Phone number']//following-sibling::input")
    public WebElement searchPhoneNumberBox;

    @FindBy(xpath = "//span[@class='ml-2']")
    public WebElement resultFullName;

    @FindBy(xpath = "(//td[@class='text-start'])[2]")
    public WebElement resultEmailAddress;

    @FindBy (xpath = "(//td[@class='text-start'])[3]")
    public WebElement resultUsername;

    @FindBy(xpath = "(//td[@class='text-start'])[5]//span")
    public WebElement resultPhoneNumber;

    @FindBy(xpath = "((//td[@class='text-start'])[6]//span)[2]")
    public WebElement resultRole;

    @FindBy(xpath = "(//td[@class='text-start'])[7]")
    public WebElement resultAdvisor;


}
