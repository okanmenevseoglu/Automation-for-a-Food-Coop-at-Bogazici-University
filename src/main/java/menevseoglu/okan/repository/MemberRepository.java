package menevseoglu.okan.repository;

import menevseoglu.okan.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by okanm on 25.03.2016.
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    Member findByEmail(String email);

    void deleteByEmail(String email);
}
