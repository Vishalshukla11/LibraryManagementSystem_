package library.services;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import library.models.BorrowingRecord;

public class simpleBorrowService implements BorrowingService{
    private List<BorrowingRecord> borrowingRecords=new ArrayList<>();

    @Override
    public void borrowBook(String memberid, String bookIsbn, java.util.Date date, java.util.Date duedate) {
      borrowingRecords.add(new BorrowingRecord(memberid, bookIsbn, date, date));
    }

    @Override
    public void returnBook(String memberId, String bookIsbn) {
       Iterator<BorrowingRecord>iterator=borrowingRecords.iterator();
       while(iterator.hasNext())
       {
        BorrowingRecord record=iterator.next();
        if(record.getMemberId().equals(memberId) && record.getBookIsbn().equals(bookIsbn))
        {
            iterator.remove();
        }
       }
    }

    @Override
    public List<BorrowingRecord> getBorrowedBookBymember(String memberid) {
       List<BorrowingRecord> result=new ArrayList<>();
       for(BorrowingRecord record : borrowingRecords)
       {
        if(record.getMemberId().equals(memberid))
        {
            result.add(record);
        }
       }
       return result;
    }

    @Override
    public List<BorrowingRecord> getAllBorrowBooks() {
        return new ArrayList<>(borrowingRecords);
    }

    



    
}