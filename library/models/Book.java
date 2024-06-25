package library.models;
public class Book
{
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int yearofPublisher;

    public Book(String isbn,String title, String author,String publisher,int yearofPublisher)
    {
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.publisher=publisher;
        this.yearofPublisher=yearofPublisher;

    }

    public String getIsbn()
    {
        return isbn;
    }
    public void setIsbn(String title)
    {
        this.title=title;
    }
    
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getTitle()
    {
        return title;
    }
   
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public String getAuthor()
    {
        return author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher=publisher;
    }
    public String getpublisher()
    {
        return publisher;
    }
    public void setyearofPublisher(int yearofPublisher)
    {
        this.yearofPublisher=yearofPublisher;
    }
    public int getyearofPublisher()
    {
        return yearofPublisher;
    }

} 