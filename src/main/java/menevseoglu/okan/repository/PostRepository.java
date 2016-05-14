package menevseoglu.okan.repository;

import menevseoglu.okan.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the post is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}
