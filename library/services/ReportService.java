package library.services;
import java.util.List;

import library.models.Book;
import library.models.BorrowingRecord;
public interface ReportService {
List<BorrowingRecord>generateOverdueBooksReport();
List<BorrowingRecord>generateborrowedBooksreport();
List<Book> generateAvailableBooksreport();
    
}