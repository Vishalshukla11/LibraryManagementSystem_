package library.services;
import java.util.Date;
import java.util.List;

import library.models.BorrowingRecord;
public class SimpleFineService implements FindService
{
   private BorrowingService borrowingService;
   private static final double daily_fine=1.0;
   public SimpleFineService(BorrowingService borrowingService)
   {
    this.borrowingService=borrowingService;

   }
    @Override
    public double calculateFine(String memberid, String bookIsbn, Date returndate) {
       //get all borrowed books
       List<BorrowingRecord> allBorrowedBooks= borrowingService.getAllBorrowBooks();
       BorrowingRecord Record=null;

       //find the specific Borrowing record
       for(BorrowingRecord r: allBorrowedBooks)
       {
         if(r.getMemberId().equals(memberid) && r.getBookIsbn().equals(bookIsbn))
         {
            Record=r;
            break;
         }

       }

       //if no matching record is found,return no fine
       if(Record==null)
       {
        return 0.0;
       }

      //calculate the diffrence in milliseconds between the return date and due date 
      long diffInMillis=returndate.getTime()-Record.getDueDate().getTime();
    //calculate the difference in milliseconds between the return date and due date 
       long diffInDays = diffInMillis/(1000*60*60*24);
       //if the book is returned late,calculate the fine ,otherwise return 0.0
       return diffInDays>0?diffInDays*daily_fine:0.0;
    }

}