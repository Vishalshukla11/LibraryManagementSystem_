package library.services;
import java.util.Date;
public interface FindService
{

    double calculateFine(String memberid,String bookIsbn,Date returndate);
}