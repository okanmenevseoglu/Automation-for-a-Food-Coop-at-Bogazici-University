package menevseoglu.okan.repository;

import menevseoglu.okan.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by okanm on 27.03.2016.
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Short> {

}
