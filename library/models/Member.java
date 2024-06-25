package library.models;
public class Member
{
    private String memberId;
    private String name;
    private String address;
    private String contactDetails;

    //constructor
    public Member(String memberId ,String name,String address, String contactDetails)
    {
        this.memberId=memberId;
        this.name=name;
        this.address=address;
        this.contactDetails = contactDetails;

    }
    //getter setter 
    public String getContactDetails()
    {
        return contactDetails;
    }
    public  void setContactDetails(String contactDetails)
    {
        this.contactDetails=contactDetails;
    }

    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getName()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name=name;
    }
    public String getMemberId()
    {
        return memberId;
    }
    public void setMemberId(String memberId)
    {
        this.memberId=memberId;
    }


}