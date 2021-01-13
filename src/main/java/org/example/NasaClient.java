package org.example;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NasaClient {
    String baseUri = "https://images-api.nasa.gov";
    String basePath = "search";

    public List<Object> getMarsImages() {
        RequestSpecification request = given().baseUri(baseUri).basePath(basePath)
                .queryParam("q", "mars")
                .queryParam("year_start", "2018")
                .queryParam("year_end", "2018")
                .queryParam("keywords", "Mars Exploration Rover (MER)")
                .queryParam("secondary_creator", "NASA/JPL-Caltech");

        Response response = request.get();

        List<Object> urls = response.jsonPath().getList("collection.items.links.href");

        return urls;
    }
}
