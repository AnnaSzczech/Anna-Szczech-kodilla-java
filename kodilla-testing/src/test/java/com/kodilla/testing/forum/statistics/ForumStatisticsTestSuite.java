package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("\nAll tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("\nPreparing to execute test #" + testCounter);
    }

    //Test 1: Poprawność obliczeń wartości średnich gdy liczba postów = 0
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfPostsIs0(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of posts is 0");
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 2: Poprawność obliczeń wartości średnich gdy liczba postów = 1000
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfPostsIs1000(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of posts is 1000");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        listOfUserNames.add("user1");
        listOfUserNames.add("user2");
        listOfUserNames.add("user3");
        listOfUserNames.add("user4");
        listOfUserNames.add("user5");
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.usersNames()).thenReturn(listOfUserNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(200.0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(20.0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(0.1, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 3: Poprawność obliczeń wartości średnich gdy liczba komentarzy = 0
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfCommentsIs0(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of comments is 0");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        listOfUserNames.add("user1");
        listOfUserNames.add("user2");
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.usersNames()).thenReturn(listOfUserNames);
        when(statisticsMock.postsCount()).thenReturn(10);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(5.0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 4: Poprawność obliczeń wartości średnich gdy liczba komentarzy < liczba postów
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfCommentsIsLessThanNumberOfPosts(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of comments is less than number of posts");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        listOfUserNames.add("user1");
        listOfUserNames.add("user2");
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.usersNames()).thenReturn(listOfUserNames);
        when(statisticsMock.postsCount()).thenReturn(20);
        when(statisticsMock.commentsCount()).thenReturn(5);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(10.0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(2.5, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(0.25, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 5: Poprawność obliczeń wartości średnich gdy liczba komentarzy > liczba postów
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfCommentsIsGreaterThanNumberOfPosts(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of comments is greater than number of posts");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        listOfUserNames.add("user1");
        listOfUserNames.add("user2");
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.usersNames()).thenReturn(listOfUserNames);
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(20);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(2.5, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(10.0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(4.0, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 6: Poprawność obliczeń wartości średnich gdy liczba użytkowników = 0
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfUsersIs0(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of users is 0");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.postsCount()).thenReturn(1);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(0.0, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }

    //Test 7: Poprawność obliczeń wartości średnich gdy liczba użytkowników = 100
    @Test
    public void testCalculateAdvStatisticsWhenNumberOfUsersIs100(){
        //given
        System.out.println("Testing CalculateAdvStatistics() when number of users is 100");
        Statistics statisticsMock = mock(Statistics.class);
        List<String> listOfUserNames = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listOfUserNames.add("user" +(i+1));
        }
        ForumStatistics forumStatistics = new ForumStatistics();
        //when
        when(statisticsMock.usersNames()).thenReturn(listOfUserNames);
        when(statisticsMock.postsCount()).thenReturn(150);
        when(statisticsMock.commentsCount()).thenReturn(450);
        forumStatistics.calculateAdvStatistics(statisticsMock);
        //then
        Assert.assertEquals(1.5, forumStatistics.getAverageNumberOfPostsPerUser(), 0.1);
        Assert.assertEquals(4.5, forumStatistics.getAverageNumberOfCommentsPerUser(), 0.1);
        Assert.assertEquals(3.0, forumStatistics.getAverageNumberOfCommentsPerPosts(), 0.1);
    }
}
