package menevseoglu.okan.repository;

import menevseoglu.okan.model.PostType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the post type is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface PostTypeRepository extends CrudRepository<PostType, Short> {
}
