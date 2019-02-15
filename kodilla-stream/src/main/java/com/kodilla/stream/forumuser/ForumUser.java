package com.kodilla.stream.forumuser;

import java.sql.SQLOutput;
import java.time.LocalDate;

public final class ForumUser {
    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberOfPosts;

    public ForumUser(final int userID, final String userName, final char sex, final LocalDate dateOfBirth, final int numberOfPosts) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberOfPosts = numberOfPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    @Override
    public String toString(){
        return userName + ", płeć: " + sex + ", data urodzenia: " + dateOfBirth + ", liczba postów: " + numberOfPosts;
    }
}
