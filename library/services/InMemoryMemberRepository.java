package library.services;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import library.models.Member;

public class InMemoryMemberRepository implements MemberRepository
{
    private Map<String, Member> members= new HashMap<>();

    @Override
    public void addMember(Member member) {
        members.put(member.getMemberId(),member);
        
    }

    @Override
    public void removemember(String memberId) {
        members.remove(memberId);
        
    }

    @Override
    public Member searchmemberById(String memberid) {
    return members.get(memberid);
    }

    @Override
    public List<Member> searchMembersByName(String name) {
        List<Member>result=new ArrayList<>();
        for(Member member: members.values())
        {
            if(member.getName().contains(name))
            {
               result.add(member); 
            }
        }
       return result;
    }

   
}