package menevseoglu.okan.repository;

import menevseoglu.okan.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by okanm on 27.03.2016.
 */
public interface ProductRepository extends CrudRepository<Product, Short> {
}
