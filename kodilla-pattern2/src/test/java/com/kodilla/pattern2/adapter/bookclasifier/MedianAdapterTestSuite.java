package com.kodilla.pattern2.adapter.bookclasifier;

import com.kodilla.pattern2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //given
        Set<Book> booksA = new HashSet<>();
        booksA.add(new Book("author1", "title1", 1999, "7645321"));
        booksA.add(new Book("author2", "title2", 2000, "3374574"));
        booksA.add(new Book("author3", "title3", 1997, "4647575"));
        booksA.add(new Book("author4", "title4", 1995, "2546757"));
        booksA.add(new Book("author5", "title5", 1998, "4646645"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //when
        int median = medianAdapter.publicationYearMedian(booksA);
        //when
        Assert.assertEquals(1998, median);
    }

}