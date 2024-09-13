package ext.group3.step_definitions;

import com.github.javafaker.Faker;
import ext.group3.pages.docuport.DocuInvitationPage;
import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_DB.DB_Utility;
import io.cucumber.java.en.*;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ext.group3.pages.docuport.DocuInvitationPage.getAccessToken;
import static ext.group3.pages.docuport.DocuInvitationPage.reqSpec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class Docuport_invitation_api_vs_db {



    public static final Logger LOG = LogManager.getLogger();
    String base = Environment.BASE_URL;
    String endPoint = "/api/v1/document/invitations/send";
    String reqBody;
    Response response;

    @When("user sends POST request to {string} with the following info {string}")
    public void user_sends_post_request_to_with_the_following_info(String endpoint, String email) {

         reqBody = "{\n" +
                "  \"recipientEmailAddress\": \"laurissss@gmail.com\"\n" +
                "}";

        System.out.println(getAccessToken("advisor"));

         response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(reqBody)
                .and().header("Authorization", getAccessToken("advisor") )
                .when().post( base + endpoint);
    }


    @Then("status code is {int}")
    public void status_code_is(Integer expected) {
        assertThat(response.getStatusCode(), is(expected));
    }

    @Then("cdataBase should persist same client info")
    public void cdata_base_should_persist_same_client_info() {
//        String sqlQuery = "SELECT * FROM document.invitations WHERE recipient = 'laurissss@gmail.com'";
//        List<Map<String, Object>>  actDBMap = DB_Utility.getQueryResultMap(sqlQuery);
//
//        String dbRecipient = ""+actDBMap.get("recipient");
//        System.out.println(dbRecipient);

    }
}
