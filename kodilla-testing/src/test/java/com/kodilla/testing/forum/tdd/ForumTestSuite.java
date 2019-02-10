package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests(){
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //Test 1: sprawdzający, czy po dodaniu nowego postu liczba postów wynosi 1.
    @Test
    public void testAddPost(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        //when
        forumUser.addPost("aszczech", "Hello everyone, this is my first contribution here!");
        //then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    //Test 2: sprawdzający, czy po dodaniu nowego komentarza liczba komentarzy wynosi 1.
    @Test
    public void testAddComment(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        //when
        forumUser.addComment(thePost, "aszczech", "Thank you for all good words!");
        //then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    //Test 3: sprawdzający, czy post pobrany z klasy ForumUser jest taki sam, jak post, który był wstawiany do klasy.
    @Test
    public void testGetPost(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
        //when
        ForumPost retrievedPost = forumUser.getPost(0);
        //then
        Assert.assertEquals(thePost, retrievedPost);
    }

    // Test 4: sprawdzający, czy komentarz pobrany z klasy ForumUser jest taki sam, jak komentarz, który był wstawiany do klasy.
    @Test
    public void testGetComment(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "aszczech");
        forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());
        //when
        ForumComment retrievedComment = forumUser.getComment(0);
        //then
        Assert.assertEquals(theComment, retrievedComment);
    }

    //Test 5: sprawdzający, czy próba usunięcia nieistniejącego posta skończy się zwróceniem wyniku false.
    @Test
    public void testRemovePostNotExisting(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        //when
        boolean result = forumUser.removePost(thePost);
        //then
        Assert.assertFalse(result);
    }

    //Test 6: sprawdzający, czy próba usunięcia nieistniejącego komentarza skończy się zwróceniem wyniku false.
    @Test
    public void testRemoveCommentNotExisting() {
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "aszczech");
        //when
        boolean result = forumUser.removeComment(theComment);
        //then
        Assert.assertFalse(result);
    }

    //Test 7: weryfikujący, czy udało się usunąć wybrany post z klasy.
    @Test
    public void testRemovePost(){
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
        //when
        boolean result = forumUser.removePost(thePost);
        //then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    //Test 8: weryfikujący, czy udało się usunąć wybrany komentarz z klasy.
    @Test
    public void testRemoveComment() {
        //given
        ForumUser forumUser = new ForumUser("aszczech", "Anna Szczech");
        ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "aszczech");
        ForumComment theComment = new ForumComment(thePost, "Thank you for all good words!", "aszczech");
        forumUser.addComment(theComment.getForumPost(), theComment.getAuthor(), theComment.getCommentBody());
        //when
        boolean result = forumUser.removeComment(theComment);
        //then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }
}
