package menevseoglu.okan.repository;

import menevseoglu.okan.model.Faq;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the faq is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface FaqRepository extends PagingAndSortingRepository<Faq, Short> {
}
