package org.example;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NasaClient {

    private List<Object> getImageUrls(Map<String, String> queryParams) {
        String baseUri = "https://images-api.nasa.gov";
        String searchBasePath = "search";

        Response response = new HttpClient().sendRequest(baseUri, searchBasePath, queryParams);

        List<Object> urls = response.jsonPath().getList("collection.items.links.href");

        return urls;
    }

    public List<Object> getMarsImagesUrls() {
        Map<String, String> queryParams = new HashMap<String, String>();

        queryParams.put("q", "mars");
        queryParams.put("year_start", "2018");
        queryParams.put("year_end", "2018");
        queryParams.put("keywords", "Mars Exploration Rover (MER)");
        queryParams.put("secondary_creator", "NASA/JPL-Caltech");

        return getImageUrls(queryParams);
    }

    public List<Object> getVideoUrls() {
        Map<String, String> queryParams = new HashMap<String, String>();

        queryParams.put("year_start", "2018");
        queryParams.put("year_end", "2018");
        queryParams.put("keywords", "mars");
        queryParams.put("media_type", "video");

        return getImageUrls(queryParams);
    }

}
