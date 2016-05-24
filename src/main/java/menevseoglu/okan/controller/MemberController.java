package menevseoglu.okan.controller;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
        return memberService.getMember(id);
    }

    @RequestMapping(value = "/byEmail/{email}/", method = RequestMethod.GET)
    public Member getMember(@PathVariable("email") String email) {
        return memberService.getMemberByEmail(email);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addNewMemberType(@RequestBody Member member) {
        memberService.addMember(member);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateMember(@PathVariable("id") int id, @RequestBody Member newBulletin) {
        memberService.updateMember(id, newBulletin);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal authenticate(Principal user) {
        return user;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBulletin(@Valid @PathVariable("id") short id) {
        memberService.deleteMemberById(id);
    }
}