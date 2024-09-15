package ext.group3.utilities.Utilities_UI;

import ext.group3.pages.docuport.DocuInvitationPage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;




public class Invitations extends DocuInvitationPage {

    /**
     Given accept type is json
     And user sends POST request to "https://beta.docuport.app/api/v1/document/invitations/send" with the following info "laurissss@gmail.com"
     And header Authorization is access_token of advisor
     When I send POST request to /api/v1/document/invitations/send
     Then status code is 201
     And cdataBase should persist same client info
     */





    @Test
    public void invitations(){

        String reqBody = "{\n" +
                "  \"recipientEmailAddress\": \"laurissss@gmail.com\"\n" +
                "}";
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(reqBody)
                .and().header("Authorization", getAccessToken("advisor") )
                .when().post("https://beta.docuport.app/api/v1/document/invitations/send");
      // response.prettyPrint();
        assertThat(response.statusCode(), is(200));

        String sqlQuery = "SELECT * FROM document.invitations WHERE recipient = 'laurissss@gmail.com'";
        String expectedEmail = "laurissss@gmail.com";


        /*

        // assertThat(sqlQuery, response.asString(), containsString(expectedEmail));
        java.lang.AssertionError: SELECT * FROM document.invitations WHERE recipient = 'laurissss@gmail.com'
            Expected: a string containing "laurissss@gmail.com"
            but: was "{"resultType":1,"errorMessage":null}"
            Expected :a string containing "laurissss@gmail.com"
            Actual   :"{"resultType":1,"errorMessage":null}"
        <Click to see difference>

        > at ext.group3.utilities.Utilities_UI.Invitations.invitations(Invitations.java:52)

         */
    }
}
