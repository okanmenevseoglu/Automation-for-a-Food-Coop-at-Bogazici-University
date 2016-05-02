package menevseoglu.okan.repository;

import menevseoglu.okan.model.MemberType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the member type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface MemberTypeRepository extends CrudRepository<MemberType, Short> {
}
