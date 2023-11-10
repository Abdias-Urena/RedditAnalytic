package org.example;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class RedditApiClient {
    private static final String BASE_URL = "https://www.reddit.com/r/";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public RedditDataApi.RedditResponse fetchRedditData(String topic) throws IOException {
        String url = BASE_URL + topic + ".json";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String responseBody = response.body().string();
            return gson.fromJson(responseBody, RedditDataApi.RedditResponse.class);
        }
    }

    public RedditDataApi.RedditResponse fetchWordKeys(String topic) throws IOException {
        String url = BASE_URL + topic + ".json";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            String responseBody = response.body().string();
            return gson.fromJson(responseBody, RedditDataApi.RedditResponse.class);
        }
    }

}
