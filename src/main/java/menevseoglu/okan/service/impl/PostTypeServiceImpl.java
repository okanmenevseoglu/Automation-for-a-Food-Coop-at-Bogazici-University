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
     * @should invoke findAll method of post type repository
     * @should return what post type repository returns
     */
    @Override
    public Iterable<PostType> getPostTypes() {
        return postTypeRepository.findAll();
    }

    /**
     * @param id of the post type
     * @return PostType object with the given id
     * @should invoke findOne method of post type repository with given id
     * @should return what post type repository returns
     */
    @Override
    public PostType getPostType(short id) {
        return postTypeRepository.findOne(id);
    }

    /**
     * @param postType to be saved
     * @should invoke save method of post type repository
     */
    @Override
    public void savePostType(PostType postType) {
        postTypeRepository.save(postType);
    }

    /**
     * @param id of the post type that will be deleted
     * @should invoke delete method of post type repository with given id
     */
    @Override
    public void deletePostType(short id) {
        postTypeRepository.delete(id);
    }
}
