package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PostType;
import menevseoglu.okan.repository.PostTypeRepository;
import menevseoglu.okan.service.PostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the post type operations.
 */
@Service
@Transactional
public class PostTypeServiceImpl implements PostTypeService {

    @Autowired
    PostTypeRepository postTypeRepository;

    /**
     * @return Iterable PostType object
     * @should get all the post types
     */
    @Override
    public Iterable<PostType> getPostTypes() {
        return postTypeRepository.findAll();
    }

    /**
     * @param id of the post type
     * @return PostType object with the given id
     * @should get the post type with given id
     */
    @Override
    public PostType getPostType(short id) {
        return postTypeRepository.findOne(id);
    }

    /**
     * @param postType to be saved
     * @should save the given post type to the database
     */
    @Override
    public void savePostType(PostType postType) {
        postTypeRepository.save(postType);
    }

    /**
     * @param id of the post type that will be deleted
     * @should delete the post type with given id
     */
    @Override
    public void deletePostType(short id) {
        postTypeRepository.delete(id);
    }
}
