package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Comment;
import menevseoglu.okan.repository.CommentRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the comment service operations.
 */
public class CommentServiceImplTest {

    @Mock
    CommentRepository commentRepository;

    @Mock
    private ArrayList<Comment> commentList;

    @Mock
    private Comment comment;

    @InjectMocks
    CommentServiceImpl commentService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of comment repository
     * @see CommentServiceImpl#getComments()
     */
    @Test
    public void getComments_shouldInvokeFindAllMethodOfCommentRepository() throws Exception {
        commentService.getComments();
        verify(commentRepository, times(1)).findAll();
    }

    /**
     * @verifies return what comment repository returns
     * @see CommentServiceImpl#getComments()
     */
    @Test
    public void getComments_shouldReturnWhatCommentRepositoryReturns() throws Exception {
        when(commentRepository.findAll()).thenReturn(commentList);
        assertEquals(commentService.getComments(), commentList);
    }

    /**
     * @verifies invoke findOne method of comment repository with given id
     * @see CommentServiceImpl#getComment
     */
    @Test
    public void getComment_shouldInvokeFindOneMethodOfCommentRepositoryWithGivenId() throws Exception {
        commentService.getComment(anyInt());
        verify(commentRepository, times(1)).findOne(anyInt());
    }

    /**
     * @verifies return what comment repository returns
     * @see CommentServiceImpl#getComment
     */
    @Test
    public void getComment_shouldReturnWhatCommentRepositoryReturns() throws Exception {
        when(commentRepository.findOne(anyInt())).thenReturn(comment);
        assertEquals(commentService.getComment(1), comment);
    }

    /**
     * @verifies invoke save method of comment repository
     * @see CommentServiceImpl#saveComment(menevseoglu.okan.model.Comment)
     */
    @Test
    public void saveComment_shouldInvokeSaveMethodOfCommentRepository() throws Exception {
        commentService.saveComment(comment);
        verify(commentRepository, times(1)).save(comment);
    }

    /**
     * @verifies invoke save method of comment repository with given id and new comment data
     * @see CommentServiceImpl#updateComment(int, menevseoglu.okan.model.Comment)
     */
    @Test
    public void updateComment_shouldInvokeSaveMethodOfCommentRepositoryWithGivenIdAndNewCommentData() throws Exception {
        commentService.updateComment(anyInt(), comment);
        verify(commentRepository, times(1)).findOne(anyInt());
        verify(commentRepository, times(1)).save(commentRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke save method of comment repository even if at least one data is null
     * @see CommentServiceImpl#updateComment(int, menevseoglu.okan.model.Comment)
     */
    @Test
    public void updateComment_shouldInvokeSaveMethodOfCommentRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        comment.setContent(null);
        commentService.updateComment(anyInt(), comment);
        verify(commentRepository, times(1)).findOne(anyInt());
        verify(commentRepository, times(1)).save(commentRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke delete method of comment repository with given id
     * @see CommentServiceImpl#deleteComment
     */
    @Test
    public void deleteComment_shouldInvokeDeleteMethodOfCommentRepositoryWithGivenId() throws Exception {
        commentService.deleteComment(anyInt());
        verify(commentRepository, times(1)).delete(anyInt());
    }
}
