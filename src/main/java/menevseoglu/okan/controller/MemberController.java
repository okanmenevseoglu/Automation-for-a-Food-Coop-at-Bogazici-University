package menevseoglu.okan.controller;


import menevseoglu.okan.exception.MemberNotFoundException;
import menevseoglu.okan.model.Member;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        Member member = memberService.findById(memberID);
        if (member == null) throw new MemberNotFoundException();
        return member;
    }

    @RequestMapping(value = "/members/register", method = RequestMethod.POST)
    public void addNewMemberType(@Valid @RequestBody Member member) {
        System.out.println(member.toString());
        memberService.addNewMember(member);
    }

    @RequestMapping(value = "/members/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBulletin(@Valid @PathVariable("id") short id) {
        memberService.delete(id);
    }
}