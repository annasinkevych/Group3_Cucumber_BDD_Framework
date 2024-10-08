package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class DocuportBasePage extends DocuLoginPage {

    private static final Logger LOG = LogManager.getLogger();

    public String getElementText(String text){
        /**
         * We are handling the case if the element was not found in that case it will return text = null
         */
        try {
            String xpath = "//*[normalize-space()='" + text + "']";
            return Driver.getDriver().findElement(By.xpath(xpath)).getText();
        } catch (Exception e){
            return "no such button";
        }
    }

    public String getElementTextTagAndName(String tag,String text){
        /**
         * We are handling the case if the element was not found in that case it will return text = null
         */
        try {
            String xpath = "//" + tag + "[normalize-space()='" + text + "']";
            return Driver.getDriver().findElement(By.xpath(xpath)).getText();
        } catch (Exception e){
            return "no such button";
        }
    }

    public WebElement getElement(String name){

        String xpath = "//*[normalize-space()='"+ name + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement leftNavReturnButton(String button){
        WebElement pageButton;
        try {
            pageButton = Driver.getDriver().findElement(By.xpath("//span[.='" + button + "']"));
            return pageButton;
        } catch (NoSuchElementException e) {
            LOG.error("No button: " + button + " exist");
            return null;
        } catch (Exception e){
            return null;
        }

    }

    @FindBy(xpath = "//span[contains(text(), 'Batch1 Group3')]")
    public WebElement Batch1Group3Button;

    public DocuportBasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
