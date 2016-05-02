package menevseoglu.okan.repository;

import menevseoglu.okan.model.WorkType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the work type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface WorkTypeRepository extends CrudRepository<WorkType, Short> {
}
