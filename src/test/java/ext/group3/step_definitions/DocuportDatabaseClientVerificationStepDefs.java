package ext.group3.step_definitions;

import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_DB.DB_Utility;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DocuportDatabaseClientVerificationStepDefs {

    private static final Logger LOG = LogManager.getLogger();
    ResultSet resultSet;

    @Given("a connection to the database is established using JDBC")
    public void connectionToDb() {
        DB_Utility.createConnection(Environment.DB_URL, Environment.DB_USERNAME, Environment.DB_PASSWORD);
    }

    @Then("the client details in the database should match: {string}, {string}, {string}, {string}")
    public void theClientDetailsInTheDatabaseShouldMatch(String firstName, String lastName, String email, String phoneNumber) throws SQLException {

        // Query to check if the client exists in the database
        // Using .format() to simplify code instead of concatenation
        String query = String.format(
                "SELECT * FROM identity.users WHERE first_name = '%s' AND last_name = '%s' AND email_address = '%s'",
                firstName, lastName, email
        );
//        System.out.println(query);

        // Add phone number to the query if it's provided
        if (!phoneNumber.isEmpty()) {
            query += String.format(" AND phone_number = '%s'", phoneNumber);
        }
        System.out.println(query);

//        // Add phone number to the query if it's provided
//        if (!phoneNumber.isEmpty()) {
//            query += String.format(" AND phone_number = '%s'", phoneNumber);
//        }

        // Execute the query and store the result
        resultSet = DB_Utility.runQuery(query);

        // Check if client exists
        assertTrue("Client record was not found in the database", resultSet.next());

        // Validate the details from the result set against expected data
        assertEquals("First name does not match", firstName, resultSet.getString("first_name"));
        assertEquals("Last name does not match", lastName, resultSet.getString("last_name"));
        assertEquals("Email address does not match", email, resultSet.getString("email_address"));

        // Log validation results
        if (!phoneNumber.isEmpty()) {
            LOG.info("\n\n**************************\nClient details successfully matched: \nFirst Name: {}, Last Name: {}, Email: {}, Phone Number: {}**************************\n\n", firstName, lastName, email, phoneNumber + "\n\n");
        } else {
            LOG.info("\n\n**************************\nClient details successfully matched: \nFirst Name: {}, Last Name: {}, Email: {}**************************\n\n", firstName, lastName, email + "\n\n");
        }
    }
}
