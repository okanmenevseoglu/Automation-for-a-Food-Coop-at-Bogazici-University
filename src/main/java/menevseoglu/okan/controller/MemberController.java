package menevseoglu.okan.controller;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.request.LoginRequest;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Controller class that handles request and response methods of the member operations.
 */
@RestController
@RequestMapping(value = "/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Member> getMembers() {
        return memberService.getMembers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Member getMember(@PathVariable("id") int id) {
        return memberService.getMemberById(id);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addNewMemberType(@RequestBody Member member) {
        System.out.println("test");
        System.out.println(member.toString());
        memberService.addMember(member);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateMember(@PathVariable("id") int id, @RequestBody Member newBulletin) {
        memberService.updateMember(id, newBulletin);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Member login(@RequestBody LoginRequest request) {
        return memberService.loginMember(request);
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public Principal authenticate(Principal user) {
        return user;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBulletin(@Valid @PathVariable("id") short id) {
        memberService.deleteMemberById(id);
    }
}