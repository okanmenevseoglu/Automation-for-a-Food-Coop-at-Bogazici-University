package menevseoglu.okan.repository;

import menevseoglu.okan.model.Bulletin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the bulletin is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface BulletinRepository extends CrudRepository<Bulletin, Short> {
}
