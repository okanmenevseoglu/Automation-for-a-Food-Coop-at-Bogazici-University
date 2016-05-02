package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.repository.MemberRepository;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @Override
    public Member findById(int id) {
        return memberRepository.findOne(id);
    }

    @Override
    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public void addNewMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Iterable<Member> findAllMembers() {
        return memberRepository.findAll();
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
    public void deleteByEmail(String email) {
        memberRepository.deleteByEmail(email);
    }

    @Override
    public void delete(int id) {
        memberRepository.delete(id);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
