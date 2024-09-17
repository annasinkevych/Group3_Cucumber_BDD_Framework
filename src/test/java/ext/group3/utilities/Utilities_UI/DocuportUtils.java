package ext.group3.utilities.Utilities_UI;

import ext.group3.pages.docuport.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.Doc;
import java.time.Duration;
import java.util.List;

public class DocuportUtils {
    static POM access = new POM();
    /**
     * logins to the Docuport application
     * @param driver, which initialized in the test base
     * @param role, comes from docuport constants
     *              authos Anna
     */


    public static void login(WebDriver driver, String role) throws InterruptedException{
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default: throw new InterruptedException("There is not such a role: " + role);
        }

        loginButton.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }

    /**
     * logs out from Docuport application
     * @param driver
     * @athor nadir
     */
    public static void logOut(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    /**
     * click button from left side menu in Docuport from all permission
     * @param desiredButton
     * @author Alex S.
     */
    public static void clickLeftSideMenu(String desiredButton) {
        for (int i = 0; i < access.getDocuAdvisorHomePage().leftSideMenu.size(); i++) {
                if(access.getDocuAdvisorHomePage().leftSideMenu.get(i).getText().equalsIgnoreCase(desiredButton)){
                    access.getDocuAdvisorHomePage().leftSideMenu.get(i).click();
                }
        }
    }

    /**
     * click on client by its index
     * @param index
     * @author Alex S.
     */
    public static void clickOnClientByIndex(int index) {
        BrowserUtils.waitForVisibility(access.getDocuAdvisorClientsPage().threeDotsClients,  5);
        Driver.getDriver().findElement(By.xpath("(//i[@class='v-icon notranslate mdi mdi-dots-horizontal theme--light'])[" + index + "]")).click();
        BrowserUtils.waitForVisibility(access.getDocuAdvisorClientsPage().editClientButton,5).click();}

    /**
     * find number of clients
     * @author Alex S.
     */
    public static Integer findNumberOfClients() {
        String nums = access.getDocuAdvisorClientsPage().amountOfRows.getText();
        return Integer.parseInt(nums.substring(nums.lastIndexOf(" ")+1));}

    /**
     * find client by name
     * @param firstName
     * @param lastName
     * @author Alex S.
     */
    public static String searchingClientByName (String firstName, String lastName) {
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(By.xpath("//div[@class='v-data-footer__pagination']")),  10);
        String client = "";
        int num = DocuportUtils.findNumberOfClients() / 10;
        for (int j = 0; j <= num; j++) {
            List<WebElement> allClientOnPage = Driver.getDriver().findElements(By.xpath("//span[@class='ml-2']"));
            for (int i = 0; i <allClientOnPage.size(); i++) {
                if(allClientOnPage.get(i).getText().equals(firstName +" "+ lastName)) {
                    client = allClientOnPage.get(i).getText();
                    break;}}
            if(!client.isEmpty()) {
                break;}
            access.getDocuAdvisorClientsPage().nextPageButton.click();
            BrowserUtils.justWait(2000);}
        return client;}



}
