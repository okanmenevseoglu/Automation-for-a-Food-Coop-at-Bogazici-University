package menevseoglu.okan.repository;

import menevseoglu.okan.model.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the member is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface MemberRepository extends CrudRepository<Member, Integer> {
    Member findByEmail(String email);

    void deleteByEmail(String email);
}
