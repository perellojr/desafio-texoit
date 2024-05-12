package texoit.apis;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder{

    public static Response post(String endPoint){
        return given(getRequestSpec()).
                body("").
                when().
                post(endPoint).
                then().
        		spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response get(String endPoint){
        return given(getRequestSpec()).
                when().
                get(endPoint).
                then().
        		spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response getWithParams(String endPoint, String query, String param){
        return given(getRequestSpec()).
                param(query, param).
                when().
                get(endPoint).
                then().
        		spec(getResponseSpec()).
                extract().
                response();
    }

    public static Response put(String endPoint, String requestBody, String id) {
        return given(getRequestSpec()).
                body(requestBody).
                when().
                put(endPoint + "/" + id).
                then().
                spec(getResponseSpec()).
                extract().
                response();
    }
}
