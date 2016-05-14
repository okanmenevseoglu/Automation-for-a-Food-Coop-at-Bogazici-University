package menevseoglu.okan.repository;

import menevseoglu.okan.model.Work;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the work is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface WorkRepository extends PagingAndSortingRepository<Work, Integer> {
}
