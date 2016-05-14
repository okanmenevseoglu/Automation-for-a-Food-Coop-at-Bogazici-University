package menevseoglu.okan.repository;

import menevseoglu.okan.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the comment is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Integer> {
}
