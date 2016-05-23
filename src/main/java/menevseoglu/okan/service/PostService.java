package menevseoglu.okan.service;

import menevseoglu.okan.model.Post;

/**
 * This class is the abstract representation of the service layer for the post operations.
 */
public interface PostService {

    Iterable<Post> getPosts();

    Post getPost(int id);

    Iterable<Post> getPostsByPostTypeName(String name);

    void savePost(Post post);

    void updatePost(int id, Post newPost);

    void deletePost(int id);
}
