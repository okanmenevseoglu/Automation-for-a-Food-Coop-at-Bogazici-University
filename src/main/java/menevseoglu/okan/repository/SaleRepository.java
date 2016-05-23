package menevseoglu.okan.repository;

import menevseoglu.okan.model.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the sale is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer> {
}
