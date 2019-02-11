package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private Statistics statistics;
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPosts;

    public void calculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        averageNumberOfPostsPerUser = calculateAverageNumberOfPostsPerUser();
        averageNumberOfCommentsPerUser = calculateAverageNumberOfCommentsPerUser();
        averageNumberOfCommentsPerPosts = calculateAverageNumberOfCommentsPerPosts();
    }

    private double calculateAverageNumberOfPostsPerUser(){
        if (usersCount == 0) {
            System.out.println("Arithmetic error occurred  while counting 'postsCount/usersCount': don't divide by 0!");
            return 0;
        }
        return (double) postsCount/usersCount;
    }

    private double calculateAverageNumberOfCommentsPerUser(){
        if (usersCount == 0) {
            System.out.println("Arithmetic error occurred  while counting 'commentsCount/usersCount': don't divide by 0!");
            return 0;
        }
        return (double) commentsCount/usersCount;
    }

    private double calculateAverageNumberOfCommentsPerPosts(){
        if (postsCount == 0) {
            System.out.println("Arithmetic error occurred  while counting 'commentsCount/postsCount': don't divide by 0!");
            return 0;
        }
        return (double) commentsCount/postsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPosts() {
        return averageNumberOfCommentsPerPosts;
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
