package org.example;

import java.io.IOException;
import java.util.*;

public class RedditManager {
    private RedditApiClient redditApiClient;

    public void printRedditData(String topic) throws IOException {
        redditApiClient = new RedditApiClient();
        RedditDataApi.RedditResponse redditResponse = redditApiClient.fetchRedditData(topic);

        if (redditResponse != null && redditResponse.getData() != null) {
            List<RedditDataApi.RedditPost> posts = redditResponse.getData().getChildren();
            if (posts != null) {
                posts.forEach(post -> System.out.println("Título: " + post.getData().getTitle() +
                        "\n Puntuación: " + post.getData().getScore()));
            } else {
                System.out.println("La lista de posts es nula.");
            }
        } else {
            System.out.println("La respuesta de Reddit es nula o no contiene datos.");
        }
    }

    public void printWordKeys(String[] keyWords,String topic) throws IOException {
        redditApiClient = new RedditApiClient();
        RedditDataApi.RedditResponse redditResponse = redditApiClient.fetchWordKeys(topic);
        int count = 0;
        if (redditResponse != null && redditResponse.getData() != null) {
            List<RedditDataApi.RedditPost> posts = redditResponse.getData().getChildren();

            if (posts != null) {
                Map<String, Integer> keywordFrequencyMap = new HashMap<>();

                count = posts.stream().mapToInt(post -> (int) Arrays.stream(keyWords)
                        .filter(keyWord -> post.getData().getTitle().toLowerCase().contains(keyWord.toLowerCase()))
                        .peek(keyWord -> keywordFrequencyMap.put(keyWord, keywordFrequencyMap.getOrDefault(keyWord, 0) + 1))
                        .count()).sum();

                keywordFrequencyMap.forEach((key, value) ->
                        System.out.println("Palabra clave: " + key + ", Frecuencia: " + value));

                System.out.println("Total de coincidencias: " + count);
            } else {
                System.out.println("La lista de posts es nula.");
            }
        } else {
            System.out.println("La respuesta de Reddit es nula o no contiene datos.");
        }
    }


}
