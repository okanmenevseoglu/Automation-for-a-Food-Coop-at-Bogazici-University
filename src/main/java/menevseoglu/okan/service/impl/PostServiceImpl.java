package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Post;
import menevseoglu.okan.repository.PostRepository;
import menevseoglu.okan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the post operations.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    /**
     * @return Iterable Post object
     * @should invoke findAll method of post repository
     * @should return what post repository returns
     */
    @Override
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    /**
     * @param id of the post
     * @return Post object with the given id
     * @should invoke findOne method of post repository with given id
     * @should return what post repository returns
     */
    @Override
    public Post getPost(int id) {
        return postRepository.findOne(id);
    }

    @Override
    public Iterable<Post> getPostsByPostTypeName(String name) {
        return postRepository.findAllByPostTypeName(name);
    }

    /**
     * @param post to be saved
     * @should invoke save method of post repository
     */
    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    /**
     * @param id      of the post that will be updated
     * @param newPost to represent new values
     * @should invoke save method of post repository with given id and new post data
     * @should invoke save method of post repository even if at least one data is null
     */
    @Override
    public void updatePost(int id, Post newPost) {
        Post oldPost = postRepository.findOne(id);
        if (newPost.getTitle() != null)
            oldPost.setTitle(newPost.getTitle());
        if (newPost.getContent() != null)
            oldPost.setContent(newPost.getContent());
        if (newPost.getDateOfOccurrence() != null)
            oldPost.setDateOfOccurrence(newPost.getDateOfOccurrence());
        if (newPost.getMember() != null)
            oldPost.setMember(newPost.getMember());
        if (newPost.getPostType() != null)
            oldPost.setPostType(newPost.getPostType());
        postRepository.save(oldPost);
    }

    /**
     * @param id of the post that will be deleted
     * @should invoke delete method of post repository with given id
     */
    @Override
    public void deletePost(int id) {
        postRepository.delete(id);
    }
}
