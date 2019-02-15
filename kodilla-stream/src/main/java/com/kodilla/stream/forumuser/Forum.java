package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum(){
        theUserList.add(new ForumUser(1, "Łukasz Kowalski", 'M', LocalDate.of(1989,12,1), 14));
        theUserList.add(new ForumUser(2, "Kasia Kowalska", 'K', LocalDate.of(1979,3,3), 22));
        theUserList.add(new ForumUser(3, "Łukasz Szczech", 'M', LocalDate.of(2012,4,3), 45));
        theUserList.add(new ForumUser(4, "Karol Nowak", 'M', LocalDate.of(1994,9,20), 0));
        theUserList.add(new ForumUser(5, "Łukasz Nowak", 'M', LocalDate.of(1997,9,20), 3));
        theUserList.add(new ForumUser(6, "Anna Szczech", 'K', LocalDate.of(2003,3,3), 2));
    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theUserList);
    }
}
