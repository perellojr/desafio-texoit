package texoit.apis;

import texoit.enums.EndPoint;
import io.restassured.response.Response;

public class JSONPlaceholderAPI {

    public JSONPlaceholderAPI(){
    }

    public Response getCommentsParam(String query, String valor){
        return ApiRequest.getWithParams(EndPoint.COMMENTS.url, query, valor);
    }

    public Response postUsers(){
        return ApiRequest.post(EndPoint.USERS.url);
    }

    public Response putUsers(String requestBody, String id){
        return ApiRequest.put(EndPoint.USERS.url, requestBody, id);
    }

}
