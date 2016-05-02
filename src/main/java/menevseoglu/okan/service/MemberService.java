package menevseoglu.okan.service;

import menevseoglu.okan.model.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by okanm on 20.04.2016.
 */
public interface MemberService extends UserDetailsService {

    Member findById(int id);

    Member findByEmail(String email);

    void addNewMember(Member member);

    Iterable<Member> findAllMembers();

    long countMembers();

    boolean isExists(int id);

    void deleteByEmail(String email);

    void delete(int id);
}
