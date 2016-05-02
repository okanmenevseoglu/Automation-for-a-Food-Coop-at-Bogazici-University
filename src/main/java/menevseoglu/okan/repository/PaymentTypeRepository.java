package menevseoglu.okan.repository;

import menevseoglu.okan.model.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the payment type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface PaymentTypeRepository extends CrudRepository<PaymentType, Short> {
}
