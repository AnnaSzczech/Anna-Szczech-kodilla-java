package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //given
        Library library = new Library("Original library");
        IntStream.iterate(1, n -> n + 1)
                .limit(9)
                .forEach(n -> library.getBooks().add(new Book("title " + n, "author " + n, LocalDate.of(1987, n, 1))));
        Book book = new Book("Gra o tron", "George R.R. Martin", LocalDate.of(1996,8, 1));
        library.getBooks().add(book);

        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow copy of Library");
        } catch (CloneNotSupportedException e){
            System.out.println(e.toString());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep copy of Library");
        } catch (CloneNotSupportedException e){
            System.out.println(e.toString());
        }
        //when
        library.getBooks().remove(book);
        //then
        System.out.println(library.toString());
        System.out.println(shallowClonedLibrary.toString());
        System.out.println(deepClonedLibrary.toString());
        Assert.assertEquals(9, library.getBooks().size());
        Assert.assertEquals(9, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(10, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(shallowClonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());

    }
}
