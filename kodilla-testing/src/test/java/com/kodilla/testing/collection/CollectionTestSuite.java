package com.kodilla.testing.collection;

import org.junit.*;
import java.util.ArrayList;

public class CollectionTestSuite {
    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> emptyList = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Test: testOddNumbersExterminatorEmptyList");
        //Then
        Assert.assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList (){
        ArrayList<Integer> listWithOddAndEvenNumbers = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            listWithOddAndEvenNumbers.add(i);
        }
        // Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> listWithEvenNumbers = oddNumbersExterminator.exterminate(listWithOddAndEvenNumbers);
        System.out.println("Test: testOddNumbersExterminatorNormalList");
        //Then
//        Assert.assertTrue(listWithEvenNumbers.get(0) % 2 == 0);
        for (int number : listWithEvenNumbers) {
            Assert.assertTrue(number % 2 == 0);
        }
    }
}
