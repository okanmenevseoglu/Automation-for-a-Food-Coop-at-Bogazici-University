package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.repository.MemberRepository;
import menevseoglu.okan.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by okanm on 20.04.2016.
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

}
