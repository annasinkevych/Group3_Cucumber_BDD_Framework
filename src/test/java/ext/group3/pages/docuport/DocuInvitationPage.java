package ext.group3.pages.docuport;

import ext.group3.utilities.Utilities_API.Environment;
import ext.group3.utilities.Utilities_UI.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static io.restassured.specification.ResponseSpecification.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class DocuInvitationPage {
    public static RequestSpecification reqSpec;
    protected static ResponseSpecification resSpec;

    @BeforeAll
    public static void setUp() {
//        baseURI = ConfigurationReader.getProperties("base_url");
        baseURI = Environment.BASE_URL;
        reqSpec = given()
                .accept(ContentType.JSON)
                .header("Authorization", getAccessToken("advisor"));
        resSpec = expect()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON);
    }

    public static String getAccessToken (String userType) {

        String userEmail = "";
        String userPassword = "";

        switch (userType){
            case "employee":
                userEmail = "b1g1_employee@gmail.com";  // b1g2_employee@gmail.com
                userPassword = "Group1";
                break;
            case "supervisor":
                userEmail = "b1g1_supervisor@gmail.com";
                userPassword = "Group1";
                break;
            case "advisor":
                userEmail = "b1g1_advisor@gmail.com";
                userPassword = "Group1";
                break;
            case "client":
                userEmail = "b1g1_client@gmail.com";
                userPassword = "Group1";
                break;
            default:
                throw new RuntimeException("Invalid user type: \"" + userType + " us not a valid usertype, or is not implemented on the switch case" );
        }


        String reqBody = "{\n" +
                "                 \"usernameOrEmailAddress\": \""+ userEmail +"\",\n" +
                "                 \"password\": \""+ userPassword +"\"\n" +
                "             }";
//https://beta.docuport.app
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .and().body(reqBody)
                .when().post(Environment.BASE_URL+ "/api/v1/authentication/account/authenticate");


        // System.out.println("Access Token: " + response.path("user.jwtToken.accessToken"));
        String accessToken = response.path("user.jwtToken.accessToken");
        assertTrue(accessToken != null && !accessToken.isEmpty());

        return "Bearer " + accessToken;
    }
}
