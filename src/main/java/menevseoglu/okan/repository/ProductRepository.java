package menevseoglu.okan.repository;

import menevseoglu.okan.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the product is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Short> {
}
