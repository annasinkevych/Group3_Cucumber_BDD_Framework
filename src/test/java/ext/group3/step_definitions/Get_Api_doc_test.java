package ext.group3.step_definitions;

import ext.group3.utilities.Utilities_API.DocuportAPITestBase;
import ext.group3.utilities.Utilities_API.DocuportApiUtil;
import ext.group3.utilities.Utilities_API.Environment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get_Api_doc_test extends DocuportAPITestBase {

    public static final Logger LOG = LogManager.getLogger();
    String baseURL = Environment.BASE_URL;
    String accessToken;
    Response response;

    @Given("the user logged in to Docuport api as advisor role")
    public void the_user_logged_in_to_docuport_api_as_advisor_role() {
        String username = Environment.ADVISOR_EMAIL;
        String password = Environment.ADVISOR_PASSWORD;

        LOG.info("Authorizing adviser role: email: " + username + ", password: " + password);
        LOG.info("Base URL: " + Environment.BASE_URL);

        accessToken = DocuportApiUtil.getAccessToken(username, password);

        if (accessToken.equals("Bearer null")) {
            LOG.error("Error getting access token");
        }
    }
    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given().accept(ContentType.JSON)
                .and().header("Authorization", accessToken)
                .when().get(baseURL + endpoint);

    }
    @Then("the response status should be {int}")
    public void the_response_status_should_be(int expectedStatusCode) {

        assertEquals("Status code verification failed: ", expectedStatusCode, response.statusCode());

    }
    @Then("the response should be in {string} format")
    public void the_response_should_be_in_format(String expectedContentType) {

        assertEquals("Response Content Type failed: ", expectedContentType, response.contentType());
        response.then().contentType(ContentType.JSON);

    }
    @Then("the response should contain file name is {string}")
    public void the_response_should_contain_file_name_is(String expectedFileName) {

        Assertions.assertEquals (expectedFileName, response.path( "items[0].displayName"));

    }


    @Then("client name is {string}")
    public void client_name_is(String expectedClientName) {

        Assertions.assertEquals (expectedClientName, response.path( "items[0].client"));

    }




}
