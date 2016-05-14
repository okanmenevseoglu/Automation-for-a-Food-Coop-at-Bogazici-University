package menevseoglu.okan.repository;

import menevseoglu.okan.model.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the producer is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface ProducerRepository extends CrudRepository<Producer, Short> {
}
