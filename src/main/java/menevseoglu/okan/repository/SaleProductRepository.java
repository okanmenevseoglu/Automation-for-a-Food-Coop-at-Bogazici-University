package menevseoglu.okan.repository;

import menevseoglu.okan.model.SaleProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the sale-product is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface SaleProductRepository extends CrudRepository<SaleProduct, Integer> {
}
