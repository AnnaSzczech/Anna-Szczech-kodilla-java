package com.kodilla.testing.library;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BookLibraryTestSuite {
    @Test
    public void testListBooksInHandsOfWhenLibraryUserHave0Books() {
        //given
        LibraryUser libraryUser1 = new LibraryUser("Jan", "Kowalski", "85010112235");
        LibraryUser libraryUser2 = new LibraryUser("Anna", "Nowak", "89020212236");
        LibraryUser libraryUser3 = new LibraryUser("Basia", "Kowalska", "82030312256");
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf1Book = generateListOfNBooks(1);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(resultListOf1Book);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(resultListOf5Books);
        //when
        List<Book> theListOf0Books = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theListOf1Book = bookLibrary.listBooksInHandsOf(libraryUser2);
        List<Book> theListOf5Books = bookLibrary.listBooksInHandsOf(libraryUser3);
        //then
        Assert.assertEquals(0, theListOf0Books.size());
        Assert.assertEquals(1, theListOf1Book.size());
        Assert.assertEquals(5, theListOf5Books.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
