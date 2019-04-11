package com.kodilla.patterns.strategy.social;

public class User{
    private final String name;
    protected SocialPublisher socialPublisher;

    public User(final String name){
        this.name = name;
    }

    public void setSocialPublisher(SocialPublisher socialPublisher){
        this.socialPublisher = socialPublisher;
    }

    public String sharePost(){
        return socialPublisher.share();
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}