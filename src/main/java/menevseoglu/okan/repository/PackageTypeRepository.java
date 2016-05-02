package menevseoglu.okan.repository;

import menevseoglu.okan.model.PackageType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the package type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface PackageTypeRepository extends CrudRepository<PackageType, Short> {
}
