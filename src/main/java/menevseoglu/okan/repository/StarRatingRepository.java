package menevseoglu.okan.repository;

import menevseoglu.okan.model.StarRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the star rating is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface StarRatingRepository extends CrudRepository<StarRating, Integer> {
}
