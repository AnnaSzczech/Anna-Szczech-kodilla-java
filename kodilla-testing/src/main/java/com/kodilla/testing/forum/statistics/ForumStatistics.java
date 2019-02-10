package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    public Statistics statistics;
    public int usersCount;
    public int postsCount;
    public int commentsCount;
    public double averageNumberOfPostsPerUser;
    public double averageNumberOfCommentsPerUser;
    public double averageNumberOfCommentsPerPosts;

    public void calculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        averageNumberOfPostsPerUser = postsCount/usersCount;
        averageNumberOfCommentsPerUser = commentsCount/usersCount;
        averageNumberOfCommentsPerPosts = commentsCount/postsCount;
    }

    public void showStatistics() {
        System.out.println("Liczba użytkowników: " + usersCount);
        System.out.println("Liczba postów: " + postsCount);
        System.out.println("Liczba komentarzy: " + commentsCount);
        System.out.println("Średnia liczba postów na użytkownika: " + averageNumberOfPostsPerUser);
        System.out.println("Średnia liczba komentarzy na użytkownika: " + averageNumberOfCommentsPerUser);
        System.out.println("Średnia liczba komentarzy na post: " + averageNumberOfCommentsPerPosts);
    }
}
