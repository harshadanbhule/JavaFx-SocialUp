package com.example.dashboards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DataUrls {
    public StringBuffer getResponseData() throws IOException {
        String url = "https://newsapi.org/v2/top-headlines?country=in&category=entertainment&apiKey=78b6f6bfd45749d7ab132e12fb413b36";

        HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
        httpClient.setRequestMethod("GET");
        StringBuffer response = new StringBuffer();
        int responseCode = httpClient.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response;

        } else {
            throw new RuntimeException("GET request failed with response code " + responseCode);
        }
    }
}
