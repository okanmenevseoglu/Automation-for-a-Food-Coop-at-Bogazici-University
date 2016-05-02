package menevseoglu.okan.repository;

import menevseoglu.okan.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the product category is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Short> {
}
