package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuClientPage extends DocuportBasePage {

    private static final Logger LOG = LogManager.getLogger();



    public WebElement getSuccessMessagePopUp(String fullname) {
        WebElement element;
        try{
            element = Driver.getDriver().findElement(By.xpath("//span[.='" + fullname + " has been updated successfully']"));
            BrowserUtils.waitForVisibility(element, 3);
            BrowserUtils.clickWithJS(element);
            return element;
        }catch(NoSuchElementException e){
            LOG.error("Element not found: //span[.='" + fullname + " has been updated successfully']");
            return null;
        }
    }

    /**
     * This method locates the element, waits for its visibility and clicks on it when it becomes visible. If it is not visible try/catch handles the exception
     * @param name
     */
    //for "Clients" and clientType - "Personal",  "Create new client"
    public void clickOnTabLeftNavMenu(String name){
        try{
            WebElement element = Driver.getDriver().findElement(By.xpath("//span[.='"+ name +"'] | //span[.='"+name+"']/span"));
            BrowserUtils.waitForClickable(element, 3);
            BrowserUtils.clickWithJS(element);
            BrowserUtils.waitForVisibility(element, 3);
        }catch(NoSuchElementException e){
            LOG.error("Element not found: //h2[.='"+name +"']");
        }
    }

    public WebElement elementIsDisplayed(String elementName){
        WebElement element;
        try {
            element = Driver.getDriver().findElement(By.xpath("//span[.='" + elementName + "']"));
            BrowserUtils.waitForVisibility(element, 3);
            return element;
        } catch (NoSuchElementException e) {
            LOG.error("No element: " + elementName + " exist");
            return null;
        } catch (Exception e){
            return null;
        }
    }

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


    public DocuClientPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
