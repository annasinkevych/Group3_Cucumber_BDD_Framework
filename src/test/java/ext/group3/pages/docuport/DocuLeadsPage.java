package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_UI.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuLeadsPage {

    public DocuLeadsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//td[text()='s@m.e']/following-sibling::td//i")
    public WebElement leadsDetailsPage;

}
