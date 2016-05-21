package menevseoglu.okan.service;

import menevseoglu.okan.model.Member;
import menevseoglu.okan.request.LoginRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by okanm on 20.04.2016.
 */
public interface MemberService extends UserDetailsService {
    Iterable<Member> getMembers();

    Member getMemberById(int id);

    Member getMemberByEmail(String email);

    long countMembers();

    boolean isExists(int id);

    boolean isValidUser(String email, String password);

    void addMember(Member member);

    void deleteMemberById(int id);

    void deleteMemberByEmail(String email);

    void updateMember(int id, Member newBulletin);

    Member loginMember(LoginRequest request);
}
