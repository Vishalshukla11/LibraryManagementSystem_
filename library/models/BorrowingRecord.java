package library.models;
import java.util.Date;
public class BorrowingRecord
{

    private String memberId;
    private String bookIsbn;
    private Date borrowingDate;
    private Date dueDate;

    //constructor
    public BorrowingRecord(String memberId,String bookIsbn,Date borrowingDate, Date dueDate)
    {
        this.memberId=memberId;
        this.bookIsbn=bookIsbn;
        this.borrowingDate=borrowingDate;
        this.dueDate=dueDate;

    }

    //getter setter
    public void setDueDate(Date dueDate)
    {
      this.dueDate=dueDate;
    }
    public Date getDueDate()
    {
        return dueDate;
    }

    public void setBorrowingDate(Date borrowingDate)
    {
        this.borrowingDate=borrowingDate;
    }
    public Date getBorrowingDate()
    {
        return borrowingDate;
    }
    public String getMemberId()
    {
        return memberId;
    }
    public void setMemberId(String memberId)
    {
        this.memberId=memberId;
    }
    public String getBookIsbn()
    {
        return bookIsbn;
    }
    public void setBookIsbn(String bookIsbn)
    {

        this.bookIsbn=bookIsbn;
    }

}