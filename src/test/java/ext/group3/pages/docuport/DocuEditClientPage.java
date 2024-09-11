package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.BrowserUtils;
import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DocuEditClientPage extends DocuLoginPage {


    @FindBy(xpath = "//span[.=' Save ']")
    public WebElement saveButton;


    @FindBy(xpath ="")
    public WebElement advisorDropdown;
    /**
     * This method locates the text input fields and sends keys to them
     *
     * @param field
     * @param inputText
     * @author anna
     */
    public void sendKeysToTxtField(String field, String inputText) {
        //click enter for a dropdown option
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[.='" + field + "']/following-sibling::input[1]"));
        BrowserUtils.waitForVisibility(element, 3);
        element.sendKeys(inputText);
    }

    public void buttonClick(String name) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[.='"+name+"']/preceding-sibling::div | //span[.='"+name+"']"));
        BrowserUtils.waitForClickable(element, 3);
        element.click();
    }

    /**
     * Dynamic method to send keys to dropdowns using dropdown container name
     * @param containerName
     * @param value
     */


    public static void sendKeysToDropDownContainer(String containerName, String value){
        WebElement dropDown =  Driver.getDriver().findElement(By.xpath("//label[.='" + containerName + "']/following-sibling::input[1] | //label[.='"+containerName+"']/following-sibling::div/input"));
        //by sending keys we can make those options that are hidden and need to be scrolled down to - visible
        dropDown.click();
        dropDown.sendKeys(value);
        List<WebElement> options = Driver.getDriver().findElements(By.xpath("//div[@class = 'v-list-item__title']/span[.='"+value+"']"));
        options.getFirst().click();
    }


}
