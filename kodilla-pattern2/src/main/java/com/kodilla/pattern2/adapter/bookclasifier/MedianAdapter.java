package com.kodilla.pattern2.adapter.bookclasifier;

import com.kodilla.pattern2.adapter.bookclasifier.librarya.BookA;
import com.kodilla.pattern2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookB;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<BookA> books) {
        Map<BookSignature, BookB> booksFromLibraryB = new HashMap<>();
        for (BookA book : books) {
            booksFromLibraryB.put(new BookSignature(book.getSignature()), new BookB(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(booksFromLibraryB);
    }
}
