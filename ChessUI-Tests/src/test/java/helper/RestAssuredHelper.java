package helper;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;


public class RestAssuredHelper {
    private Response response;

    public Response getRequest(String uri) {
        response = given().relaxedHTTPSValidation().when().get(uri);
        return response;
    }



}
