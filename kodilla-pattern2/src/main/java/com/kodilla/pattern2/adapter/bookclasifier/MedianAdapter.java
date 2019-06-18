package com.kodilla.pattern2.adapter.bookclasifier;

import com.kodilla.pattern2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.pattern2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<com.kodilla.pattern2.adapter.bookclasifier.librarya.Book> books) {
        Map<BookSignature, Book> booksFromLibraryB = new HashMap<>();
        for (com.kodilla.pattern2.adapter.bookclasifier.librarya.Book book : books) {
            booksFromLibraryB.put(new BookSignature(book.getSignature()), new Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(booksFromLibraryB);
    }
}
