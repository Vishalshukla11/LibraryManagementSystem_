// package library;
import library.models.*;
import library.services.*;
// import library.models.Book;
// import library.models.BorrowingRecord;
// import library.models.Member;
// import library.services.BookRepository;
// import library.services.BorrowingService;
// import library.services.FindService;
// import library.services.InMemoryBookRepository;
// import library.services.InMemoryMemberRepository;
// import library.services.MemberRepository;
// import library.services.ReportService;
// import library.services.SimpleFineService;
// import library.services.SimpleReportService;
// import library.services.simpleBorrowService;

import java.util.Date;
import java.util.Scanner;

public class Main {

       private static Scanner sc = new Scanner(System.in);

       public static void main(String[] args) {
              System.out.println("Main Class");
              // create repository and services
              BookRepository bookRepository = new InMemoryBookRepository();
              MemberRepository memberRepository = new InMemoryMemberRepository();

              // CREATING SERVICES
              BorrowingService borrowingService = new simpleBorrowService();
              FindService findService = new SimpleFineService(borrowingService);
              ReportService reportService = new SimpleReportService(borrowingService, bookRepository);

              // sample data
              bookRepository.addBook(new Book("1234567890", "Effective Java", "Joshua Bloch", "Addison-Wesley", 2008));
              bookRepository.addBook(new Book("0987654321", "Clean Code", "Robert C. Martin", "Prentice Hall", 2008));
              memberRepository.addMember(new Member("M001", "Alice", "123 Main St", "alice@example.com"));
              memberRepository.addMember(new Member("M002", "Bob", "456 Elm St", "bob@example.com"));

              while (true) {
                     System.out.println("Library Management System");
                     System.out.println("1. Add Book");
                     System.out.println("2. Remove Book");
                     System.out.println("3. Search Book by ISBN");
                     System.out.println("4. Search Books by Title");
                     System.out.println("5. Add Member");
                     System.out.println("6. Remove Member");
                     System.out.println("7. Borrow Book");
                     System.out.println("8. Return Book");
                     System.out.println("9. Generate Available Books Report");
                     System.out.println("10. Generate Borrowed Books Report");
                     System.out.println("11. Generate Overdue Books Report");
                     System.out.println("12. Calculate Fine");
                     System.out.println("13. Exit");
                     System.out.print("Enter your choice: ");
                     int choice = sc.nextInt();
                     sc.nextLine();

                     switch (choice) {
                            case 1:
                            System.out.println("Enter ISBN: ");
                            String isbn=sc.nextLine();
                            System.out.println("Enter Title:");
                            String title=sc.nextLine();
                            System.out.println("Enter Auther:");
                            String author=sc.nextLine();
                            System.out.println("Enter Publisher:");
                            String publisher=sc.nextLine();
                            System.out.println("Enter year of publisher:");
                            int year =sc.nextInt();
                            bookRepository.addBook(new Book(isbn, title, author, publisher, year));
                            System.out.println("Book added successFully.");

                                   break;
                             case 2:
                             System.out.println("Enter Isbn to remove:");
                             String isbnToremove=sc.nextLine();
                             bookRepository.removeBook(isbnToremove);
                             System.out.println("Book removed successfully");
                                   break; 
                            case 3:
                            System.out.println("Enter ISBN to search: ");
                            String isbnToSearch=sc.nextLine();
                            Book book = bookRepository.searchBookByIsbn(isbnToSearch);
                            System.out.println(book !=null?book.getTitle():"Book not found");
                            break; 
                            case 4:
                            System.out.println("Enter Title to search : ");
                            String titletoSearch=sc.nextLine();
                            for(Book b : bookRepository.searchBooksByTitle(titletoSearch))  
                            {
                                   System.out.println(b.getTitle());
                            } 
                             break;
                             case 5 :
                             System.out.println("Enter Member ID");
                             String memberId=sc.nextLine();
                             System.out.println("Enter Name");
                             String name=sc.nextLine();
                             System.out.println("Enter Address:");
                             String address=sc.nextLine();
                             System.out.println("Enter contact Details");
                             String contactDetails=sc.nextLine();
                             memberRepository.addMember(new Member(memberId,name,address,contactDetails));
                             System.out.println("Member added successFully.");

                             break;
                             case 6:
                             System.out.println("Enter Member Id to remove :");
                             String memberIdToRemove=sc.nextLine();
                             memberRepository.removemember(memberIdToRemove);
                             System.out.println("Emeber removed successfully");
                             break;
                             case 7:
                             System.out.println("Enter member Id:");
                             String borrowingMemberId=sc.nextLine();
                             System.out.println("Enter Book IsBN:");
                             String borrowingBookIsbn=sc.nextLine();
                             borrowingService.borrowBook(borrowingMemberId, borrowingBookIsbn,new Date(),new Date(System.currentTimeMillis()+7*24*60*60*1000));
                             System.out.println("Book borrowed successFully.");
                             break;
                             case 8 :
                             System.out.println("Eter Member ID");
                             String returningMemberId=sc.nextLine();
                             System.out.println("Enter Book ISBN:");
                             String returningBookIsbn=sc.nextLine();
                             borrowingService.returnBook(returningMemberId, returningBookIsbn);
                             System.out.println("Book returned successfully.");
                             break;
                             case 9 :
                             System.out.println("Availabe Book:");
                             for(Book availabeBook : reportService.generateAvailableBooksreport())
                             {
                                   System.out.println(availabeBook.getTitle());
                             }
                             break;
                             case 10:
                             System.out.println("Borrowing Books:");
                             for(BorrowingRecord borrowedBook : reportService.generateborrowedBooksreport())
                             {
                                   System.out.println("Book ISBN: " + borrowedBook.getBookIsbn() + "Borrowed By Member ID: " + borrowedBook.getMemberId());
                             }
                             break;
                             case 11:
                             System.out.println("overdue Books:");
                             for(BorrowingRecord overdueBook : reportService.generateOverdueBooksReport())
                             {
                                   System.out.println("Book ISBN : " + overdueBook.getBookIsbn()+ ", Borrowed by Member ID : " + overdueBook.getMemberId());
                             }
                             break;
                             case 12:
                             System.out.println("Enter Member ID:");
                             String fineMemberId=sc.nextLine();
                             System.out.println("Enter Book ISBN: ");
                             String fineBookIsbn=sc.nextLine();
                             System.out.println("Enter return date (in miliseconds since epoch):");
                             long returnDateMillis=sc.nextLong();
                             Date returndate=new Date(returnDateMillis);
                             double fine= findService.calculateFine(fineMemberId, fineBookIsbn, returndate);
                             System.out.println("Fine rs " + fine);
                             break;
                             case 13:
                             System.out.println("Exiting..");
                             sc.close();
                             System.exit(0);
                             break;

 
                            default:
                            System.out.println("Invalid choice Please try again");
                                   break;
                     }
              }

       }
}
