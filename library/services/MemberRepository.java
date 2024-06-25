package library.services;
import java.util.List;

import library.models.Member;

public interface MemberRepository {
    void addMember(Member member);
    void removemember(String memberId);
    Member searchmemberById(String memberid);
    List<Member> searchMembersByName(String name);
    
}