package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Photo;
import menevseoglu.okan.model.Post;
import menevseoglu.okan.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the post service operations.
 */
public class PostServiceImplTest {

    @Mock
    PostRepository postRepository;

    @Mock
    private ArrayList<Post> postList;

    @Mock
    private ArrayList<Photo> photoList;

    @Mock
    private Post post;

    @InjectMocks
    PostServiceImpl postService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of post repository
     * @see PostServiceImpl#getPosts()
     */
    @Test
    public void getPosts_shouldInvokeFindAllMethodOfPostRepository() throws Exception {
        postService.getPosts();
        verify(postRepository, times(1)).findAll();
    }

    /**
     * @verifies return what post repository returns
     * @see PostServiceImpl#getPosts()
     */
    @Test
    public void getPosts_shouldReturnWhatPostRepositoryReturns() throws Exception {
        when(postRepository.findAll()).thenReturn(postList);
        assertEquals(postService.getPosts(), postList);
    }

    /**
     * @verifies invoke findOne method of post repository with given id
     * @see PostServiceImpl#getPost
     */
    @Test
    public void getPost_shouldInvokeFindOneMethodOfPostRepositoryWithGivenId() throws Exception {
        postService.getPost(anyInt());
        verify(postRepository, times(1)).findOne(anyInt());
    }

    /**
     * @verifies return what post repository returns
     * @see PostServiceImpl#getPost
     */
    @Test
    public void getPost_shouldReturnWhatPostRepositoryReturns() throws Exception {
        when(postRepository.findOne(anyInt())).thenReturn(post);
        assertEquals(postService.getPost(1), post);
    }

    /**
     * @verifies invoke save method of post repository
     * @see PostServiceImpl#savePost(menevseoglu.okan.model.Post)
     */
    @Test
    public void savePost_shouldInvokeSaveMethodOfPostRepository() throws Exception {
        postService.savePost(post);
        verify(postRepository, times(1)).save(post);
    }

    /**
     * @verifies invoke save method of post repository with given id and new post data
     * @see PostServiceImpl#updatePost(int, menevseoglu.okan.model.Post)
     */
    @Test
    public void updatePost_shouldInvokeSaveMethodOfPostRepositoryWithGivenIdAndNewPostData() throws Exception {
        postService.updatePost(anyInt(), post);
        verify(postRepository, times(1)).findOne(anyInt());
        verify(postRepository, times(1)).save(postRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke save method of post repository even if at least one data is null
     * @see PostServiceImpl#updatePost(int, menevseoglu.okan.model.Post)
     */
    @Test
    public void updatePost_shouldInvokeSaveMethodOfPostRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        post.setTitle(null);
        postService.updatePost(anyInt(), post);
        post.setContent(null);
        postService.updatePost(anyInt(), post);
        post.setDateOfOccurrence(null);
        postService.updatePost(anyInt(), post);
        post.setPostType(null);
        postService.updatePost(anyInt(), post);
        post.setMember(null);
        postService.updatePost(anyInt(), post);
        post.setPhotoList(photoList);
        postService.updatePost(anyInt(), post);
        verify(postRepository, times(6)).findOne(anyInt());
        verify(postRepository, times(6)).save(postRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke delete method of post repository with given id
     * @see PostServiceImpl#deletePost
     */
    @Test
    public void deletePost_shouldInvokeDeleteMethodOfPostRepositoryWithGivenId() throws Exception {
        postService.deletePost(anyInt());
        verify(postRepository, times(1)).delete(anyInt());
    }
}
