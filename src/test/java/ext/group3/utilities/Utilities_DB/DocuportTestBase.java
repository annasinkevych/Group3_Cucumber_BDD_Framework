package ext.group3.utilities.Utilities_DB;

import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import ext.group3.utilities.Utilities_UI.Driver;
import org.junit.jupiter.api.BeforeAll;

public class DocuportTestBase {

    @BeforeAll
    public static void beforeAll() {
        String DBUrl = ConfigurationReader.getProperties("docu.db.url");
        String DBUsername = ConfigurationReader.getProperties("docu.db.username");
        String DBPassword = ConfigurationReader.getProperties("docu.db.password");
        DB_Utility.createConnection(DBUrl, DBUsername, DBPassword);
    }

}
