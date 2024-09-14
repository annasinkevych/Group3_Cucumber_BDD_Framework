
package ext.group3.step_definitions;

import ext.group3.pages.docuport.POM;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_DB.DB_Utility;
import ext.group3.utilities.Utilities_UI.BrowserUtils;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DocuportRowsPerPageValidation {
//    POM pages = new POM();
//    public int allUserUIAmount;
//
//
//    @When(": User get amount of all users on user page")
//    public void user_get_amount_of_all_users_on_user_page() {
//        pages.getUsersPage().searchButton.click();
//        pages.getUsersPage().radioButtonAll.click();
//        pages.getUsersPage().searchButton2.click();
//        BrowserUtils.justWait(2000);
//        allUserUIAmount = pages.getUsersPage().getAllUserAmount();
//
//    }
//
//    @When(": user validates that amount of user on UI same like in DB")
//    public void user_validates_that_amount_of_user_on_ui_same_like_in_db() {
//
//        DB_Utility.createConnection(Environment.DB_URL, Environment.DB_USERNAME, Environment.DB_PASSWORD );
//        DB_Utility.runQuery("SELECT * FROM identity.users");
//        int actualDBUserAmount = DB_Utility.getRowCount();
//        assertEquals(allUserUIAmount, actualDBUserAmount);
//    }
}