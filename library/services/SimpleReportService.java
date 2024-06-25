package library.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import library.models.Book;
import library.models.BorrowingRecord;

public class SimpleReportService implements ReportService
{
    private BorrowingService borrowingService;
    private BookRepository bookRepository;

    public SimpleReportService(BorrowingService borrowingService,BookRepository bookRepository)
    {
        this.borrowingService=borrowingService;
        this.bookRepository=bookRepository;

    }

    @Override
    public List<BorrowingRecord> generateOverdueBooksReport() {
        Date currentDate=new Date();
        List<BorrowingRecord>allBorrowedBooks= borrowingService.getAllBorrowBooks();
        List<BorrowingRecord>overdueBooks=new ArrayList<>();
        for(BorrowingRecord record : allBorrowedBooks)
        {
            if(record.getDueDate().before(currentDate))
            {
                overdueBooks.add(record);
            }
        }
            return overdueBooks;
        
    }

    @Override
    public List<BorrowingRecord> generateborrowedBooksreport() {
       return borrowingService.getAllBorrowBooks();
    }

    @Override
    public List<Book> generateAvailableBooksreport() {
       List<BorrowingRecord> allBorrowedBooks=borrowingService.getAllBorrowBooks();
       List<String>borrowedIsbns=new ArrayList<>();

       for(BorrowingRecord record : allBorrowedBooks)
       {
        borrowedIsbns.add(record.getBookIsbn());
       }

       List<Book>allBooks=bookRepository.searchBooksByTitle("");
       List<Book>availaBooks=new ArrayList<>();

       for(Book book :allBooks)
       {
        if(!borrowedIsbns.contains(book.getIsbn()))
        {
            availaBooks.add(book);
        }
       }
       return availaBooks;
    }
    
}