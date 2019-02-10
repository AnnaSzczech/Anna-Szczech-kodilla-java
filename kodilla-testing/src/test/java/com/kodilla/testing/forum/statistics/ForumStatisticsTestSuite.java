package com.kodilla.testing.forum.statistics;

import org.junit.*;
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
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    //Test 1: Poprawność obliczeń wartości średnich gdy liczba postów = 0
    @Test
    public void testCalculateAdvStatistics(){
        //given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);
        when(forumStatistics.averageNumberOfPostsPerUser);
        //when
        //then
    }
}
