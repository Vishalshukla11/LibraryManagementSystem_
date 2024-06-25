package library.services;
import java.util.List;

import library.models.BorrowingRecord;

public interface BorrowingService
{
    void borrowBook(String memberid,String bookIsbn,java.util.Date date,java.util.Date date2);
    void returnBook(String memberId,String bookIsbn);
    List<BorrowingRecord> getBorrowedBookBymember(String memberid);
    List<BorrowingRecord>getAllBorrowBooks();
}