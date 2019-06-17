package com.kodilla.pattern2.adapter.bookclasifier;

import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    private Statistics statistics;

    public MedianAdaptee() {
        this.statistics = new Statistics();
    }


    @Override
    public int averagePublicationYear(Map<BookSignature, BookB> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookB> books) {
        return statistics.medianPublicationYear(books);
    }
}
