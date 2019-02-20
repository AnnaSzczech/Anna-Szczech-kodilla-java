package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyIWillThrowException(3.0, 1.5);
        } catch (Exception e) {
            System.out.println("Wrong numbers! Error: " + e);
        } finally {
            System.out.println("End of Program.");
        }
    }
}
