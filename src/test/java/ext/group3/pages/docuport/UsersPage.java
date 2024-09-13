package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.Driver;
import freemarker.core.CFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Integer.valueOf;

public class UsersPage extends DocuportBasePage{

    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public  WebElement allRadiobutton;


    @FindBy(xpath = "//span[.='Users']")
    public WebElement usersButton;

    @FindBy(xpath = "(//span[.='Search'])[1]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@role='radiogroup']")
    public List <WebElement> radioButtonsList;

        public WebElement getRadioButtonAll() {
            for (WebElement element : radioButtonsList) {
                allRadiobutton = element;
            }
        return allRadiobutton;
    }

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

    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement paginationData;


    public int getAllUserAmount(){
        String test = paginationData.getText().trim();
        int userAmount = Integer.parseInt(test.substring(test.indexOf("f")+2));
        return userAmount;
    }



}
