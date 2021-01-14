package org.example;

import java.util.List;

public class NasaApi {

    public static int MAX_COUNT = 5;

    public static void main(String[] args) {
        NasaClient nasaClient = new NasaClient();

        List<Object> images = nasaClient.getMarsImagesUrls();
        int number = (images.size() > MAX_COUNT) ? MAX_COUNT : images.size();

        System.out.println("--- " + number + " images with Mars surface: (replace 'thumb.jpg' with 'orig.tiff' to download full size image)");
        for (int i=0; i < number; i++) {
            System.out.println(images.get(i).toString());
        }

        System.out.println("--- Filetypes check:");
        List<Object> urls = nasaClient.getVideoUrls();

        for (int i=0; i < urls.size(); i++) {
            System.out.println("Link: " + i + " contains video: " + urls.get(i).toString().contains("/video/"));
            System.out.println(urls.get(i).toString().substring(0, Math.min(urls.get(i).toString().length(), 60)) + "...");
        }
    }
}
