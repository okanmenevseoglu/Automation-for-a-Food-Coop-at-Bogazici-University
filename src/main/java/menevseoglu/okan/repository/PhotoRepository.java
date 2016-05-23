package menevseoglu.okan.repository;

import menevseoglu.okan.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class indicates that the photo is a DAO component that uses Spring Data JPA in the persistence layer.
 */
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    Iterable<Photo> findAllByMemberId(int id);

    Iterable<Photo> findAllByProductId(short id);

    Iterable<Photo> findAllByProducerId(short id);

    Iterable<Photo> findAllByPostId(int id);
}
