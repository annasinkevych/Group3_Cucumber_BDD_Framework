package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.print.Doc;
import java.util.List;

public class DocuAdvisorHomePage {
    DocuAdvisorHomePage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@alt='Docuport']")
    public WebElement advisorHomePageValidator;

    @FindBy(xpath = "//div[@class='v-list-item__content']//span")
    public List<WebElement> leftSideMenu;


}
