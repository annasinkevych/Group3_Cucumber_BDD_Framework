//package ext.group3.step_definitions;
//
//import ext.group3.utilities.Utilities_API.Environment;
//import ext.group3.utilities.Utilities_DB.DB_Utility;
//import io.cucumber.java.en.*;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import java.util.Map;
//
//import static ext.group3.pages.docuport.DocuInvitationPage.getAccessToken;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//
//
//
//public class Docuport_invitation_api_vs_db {
//
//    String base = Environment.BASE_URL;
//    String reqBody;
//    Response response;
//
//    @When("user sends POST request to {string} with the following info {string}")
//    public void user_sends_post_request_to_with_the_following_info(String endpoint, String email) {
//
//        reqBody = "{\n" +
//                "  \"recipientEmailAddress\": \"laurissss@gmail.com\"\n" +
//                "}";
//
//        response = given().accept(ContentType.JSON)
//                .and().contentType(ContentType.JSON)
//                .and().body(reqBody)
//                .and().header("Authorization", getAccessToken("advisor") )
//                .when().post( base + endpoint);
//    }
//
//    @Then("status code is {int}")
//    public void status_code_is(Integer expected) {
//        assertThat(response.statusCode(), is(expected));
//    }
//
//    @Then("cdataBase should persist same client info")
//    public void cdata_base_should_persist_same_client_info() {
//
//        String sqlQuery = "SELECT * FROM document.invitations WHERE recipient = 'laurissss@gmail.com'";
//
//        Map <String,Object> dbResult =  DB_Utility.getRowMapSpecRow(sqlQuery);
//
//        String resultFromDb = "" + dbResult.get("recipient");
//
//        response = given().accept(ContentType.JSON)
//                .and().header("Authorization", getAccessToken("advisor") )
//                .when().get(Environment.BASE_URL +"/api/v1/document/invitations");
//
//        JsonPath jsonPath = response.jsonPath();
//        assertThat(response.statusCode(), is(HttpStatus.SC_OK));
//        assertThat(resultFromDb, is(jsonPath.getString("items[0].recipient")));
//
//    }
//}
