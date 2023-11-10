package org.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        RedditManager redditManager = new RedditManager();
        String topic;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Print Reddit Data");
            System.out.println("2. Print Word Keys");
            System.out.println("3. Exit");
            String option = reader.readLine();

            switch (option) {
                case "1":
                    System.out.println("Please enter your prefer topic:");
                    topic = reader.readLine();
                    redditManager.printRedditData(topic);
                    break;
                case "2":
                    System.out.println("Please enter your prefer topic:");
                    topic = reader.readLine();
                    System.out.println("Please enter your prefer word keys:");
                    String wordKeys = reader.readLine();
                    redditManager.printWordKeys(wordKeys.split(","),topic);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }
}
