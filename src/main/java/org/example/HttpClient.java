package org.example;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpClient {
    public Response sendRequest(String baseUri, String basePath, Map<String, String> queryParams) {
        RequestSpecification request = given().baseUri(baseUri).basePath(basePath)
                .queryParams(queryParams);

        Response response = request.get();

        return response;
    }
}
