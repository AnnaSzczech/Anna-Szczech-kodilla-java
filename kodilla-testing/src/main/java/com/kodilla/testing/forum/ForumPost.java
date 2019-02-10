package com.kodilla.testing.forum;

public class ForumPost {
    private String postBody;
    private String author;

    public ForumPost(String postBody, String author) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o.getClass() != getClass() || o == null) return false;

        ForumPost forumPost = (ForumPost) o;

        if (!postBody.equals(forumPost.getPostBody())) return false;
        return author.equals(forumPost.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = postBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
