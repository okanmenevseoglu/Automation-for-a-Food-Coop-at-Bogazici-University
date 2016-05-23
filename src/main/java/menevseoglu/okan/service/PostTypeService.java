package menevseoglu.okan.service;

import menevseoglu.okan.model.PostType;

/**
 * This class is the abstract representation of the service layer for the post type operations.
 */
public interface PostTypeService {

    Iterable<PostType> getPostTypes();

    PostType getPostType(short id);

    PostType getPostTypeByName(String name);

    void savePostType(PostType postType);

    void deletePostType(short id);
}
