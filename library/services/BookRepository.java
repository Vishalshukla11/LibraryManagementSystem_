package library.services;

import java.util.List;

import library.models.Book;

public interface BookRepository {
    void addBook(Book book);
    void removeBook(String isbn);
    Book searchBookByIsbn(String isbn);
    List<Book> searchBooksByTitle(String title);    
}