package ext.group3.utilities.Utilities_DB;

import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.Driver;
import io.cucumber.java.BeforeAll;


public class DocuportTestBase {

    @BeforeAll
    public static void beforeAll() {
        String DBUrl = ConfigurationReader.getProperty("docu.db.url");
        String DBUsername = ConfigurationReader.getProperty("docu.db.username");
        String DBPassword = ConfigurationReader.getProperty("docu.db.password");
        DB_Utility.createConnection(DBUrl, DBUsername, DBPassword);
    }

}
