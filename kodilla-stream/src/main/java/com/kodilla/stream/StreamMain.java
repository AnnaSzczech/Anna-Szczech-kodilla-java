package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args){
        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOdForumUsers = forum.getList().stream()
                .filter(sex -> sex.getSex() == 'M')
                .filter(age -> LocalDate.now().getYear() - age.getDateOfBirth().getYear() >= 20)
                .filter(posts -> posts.getNumberOfPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, ForumUser -> ForumUser));

        mapOdForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue()).forEach(System.out::println);

    }
}
