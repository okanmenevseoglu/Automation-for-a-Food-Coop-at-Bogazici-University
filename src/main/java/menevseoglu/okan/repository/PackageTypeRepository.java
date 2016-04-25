package menevseoglu.okan.repository;

import menevseoglu.okan.model.PackageType;
import org.springframework.data.repository.CrudRepository;

/**
 * This repository interface is created to provide an abstraction for the package type operations.
 */
public interface PackageTypeRepository extends CrudRepository<PackageType, Short> {
}
