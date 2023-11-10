package org.example;

import java.util.List;

public class RedditDataApi {
    public static class RedditResponse {
        private RedditData data;

        public RedditData getData() {
            return data;
        }
    }

    public static class RedditData {
        private List<RedditPost> children;

        public List<RedditPost> getChildren() {
            return children;
        }

    }

    public static class RedditPost {
        private RedditPostData data;

        public RedditPostData getData() {
            return data;
        }

        public void setData(RedditPostData data) {
            this.data = data;
        }
    }

    public static class RedditPostData {
        private String title;
        private double score;

        public String getTitle() {
            return title;
        }

        public double getScore() {
            return score;
        }

    }
}
