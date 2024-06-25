package library.services;

import java.util.*;

import library.models.Book;

public class InMemoryBookRepository implements BookRepository
{
    private Map<String ,Book> bookMap=new HashMap<>();

    @Override
    public void addBook(Book book) {
        bookMap.put(book.getIsbn(),book);
    }

    @Override
    public void removeBook(String isbn) {
        bookMap.remove(isbn);
        
    }

    @Override
    public Book searchBookByIsbn(String isbn) {
       
        return bookMap.get(isbn);
        
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result =new ArrayList<>();
        for(Book Book : bookMap.values()) //Iterate through each Book object in the values of bookMap
        {
            if(Book.getTitle().contains(title))//Check if the title of the current Book object contains the given title substring.
            {
                result.add(Book);
            }
        }
        return result;
    }

    

}