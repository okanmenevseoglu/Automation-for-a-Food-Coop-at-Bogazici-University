package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.repository.MemberRepository;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMember(int id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member getMemberByEmail(String email) {
        return memberRepository.findOneByEmail(email);
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
        Member member = memberRepository.findOneByEmail(email);
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
    public void deleteMemberById(int id) {
        memberRepository.delete(id);
    }

    @Override
    public void deleteMemberByEmail(String email) {
        memberRepository.deleteByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findOneByEmail(email);
    }
}

