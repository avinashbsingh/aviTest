package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private static Response resp = null;
    private static RequestSpecification request;


    public static Response getGenericRequest(String apiMethodType, Object baseUrl, String url, String body) {
        RestAssured.baseURI = baseUrl.toString();
        request = RestAssured.given();

        switch (apiMethodType.toUpperCase()) {
            case "POST":
                request.body(body);
                resp = request.post(url);
                break;
            case "GET":
                resp = request.get(url);
                break;
            case "PUT":
                request.body(body);
                resp = request.put(url);
                break;
            case "DELETE":
                resp = request.delete(url);
                break;
        }
        return resp;
    }

}
