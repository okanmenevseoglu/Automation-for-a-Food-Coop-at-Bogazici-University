package menevseoglu.okan.controller;


import menevseoglu.okan.model.Member;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * Created by okanm on 25.03.2016.
 */
@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public Iterable<Member> getMembers() {
        return memberService.findAllMembers();
    }

    @RequestMapping(value = "/members/{memberID}", method = RequestMethod.GET)
    public Member getMember(@PathVariable("memberID") int memberID) {
        return memberService.findById(memberID);
    }

    @RequestMapping(value = "/members/register", method = RequestMethod.POST)
    public void addNewMemberType(@RequestBody Member member) {
        System.out.println(member.toString());
        memberService.addNewMember(member);
    }
}