package menevseoglu.okan.repository;

import menevseoglu.okan.model.UnitType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the unit type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface UnitTypeRepository extends CrudRepository<UnitType, Short> {
}
