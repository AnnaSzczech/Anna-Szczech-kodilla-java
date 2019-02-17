package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        // Given
        int [] numbers = {5, 7, 9, 21, 15, 6, 8, 35, 23, 18, 13, 1, 31, 26, 34, 43, 45, 46, 53, 55};

        //when
        double average = ArrayOperations.getAverage(numbers);

        //then
        Assert.assertEquals(20, numbers.length);
        Assert.assertEquals(24.7, average, 0.01);
    }
}
