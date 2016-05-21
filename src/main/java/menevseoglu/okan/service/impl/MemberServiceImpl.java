package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.repository.MemberRepository;
import menevseoglu.okan.request.LoginRequest;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the member operations.
 */
@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(int id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public long countMembers() {
        return memberRepository.count();
    }

    @Override
    public boolean isExists(int id) {
        return memberRepository.exists(id);
    }

    @Override
    public boolean isValidUser(String email, String password) {
        Member member = memberRepository.findByEmail(email);
        return (member != null && member.getPassword().equals(password));
    }

    @Override
    public void addMember(Member member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);
    }

    @Override
    public void updateMember(int id, Member newMember) {
        Member oldMember = memberRepository.findOne(id);
        if (newMember.getFirstName() != null)
            oldMember.setFirstName(newMember.getFirstName());
        if (newMember.getLastName() != null)
            oldMember.setLastName(newMember.getFirstName());

        memberRepository.save(newMember);
    }

    @Override
    public Member loginMember(LoginRequest request) {
        String email = request.getName();
        String password = request.getPassword();

        System.out.println(email);
        System.out.println(password);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return this.getMemberByEmail(email);
    }

    @Override
    public void deleteMemberById(int id) {
        memberRepository.delete(id);
    }

    @Override
    public void deleteMemberByEmail(String email) {
        memberRepository.deleteByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return memberRepository.findByEmail(s);
    }
}

