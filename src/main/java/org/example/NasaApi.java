package org.example;

import java.util.List;

public class NasaApi {

    public static int MAX_COUNT = 5;

    public static void main(String[] args) {
        NasaClient nasaClient = new NasaClient();

        List<Object> images = nasaClient.getMarsImages();

        int number = images.size();

        number = (number > MAX_COUNT) ? MAX_COUNT : number;

        for (int i=0; i < number; i++) {
            System.out.println(images.get(i));
        }
    }
}
