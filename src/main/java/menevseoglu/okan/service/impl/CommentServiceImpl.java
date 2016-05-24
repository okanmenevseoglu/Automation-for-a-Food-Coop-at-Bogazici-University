package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Comment;
import menevseoglu.okan.repository.CommentRepository;
import menevseoglu.okan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the comment operations.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    /**
     * @return Iterable Comment object
     * @should invoke findAll method of comment repository
     * @should return what comment repository returns
     */
    @Override
    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Iterable<Comment> getCommentsByProductId(short id) {
        return commentRepository.findAllByProductId(id);
    }

    /**
     * @param id of the comment
     * @return Comment object with the given id
     * @should invoke findOne method of comment repository with given id
     * @should return what comment repository returns
     */
    @Override
    public Comment getComment(int id) {
        return commentRepository.findOne(id);
    }

    /**
     * @param comment to be saved
     * @should invoke save method of comment repository
     */
    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    /**
     * @param id         of the comment that will be updated
     * @param newComment to represent new values
     * @should invoke save method of comment repository with given id and new comment data
     * @should invoke save method of comment repository even if comment data is null
     */
    @Override
    public void updateComment(int id, Comment newComment) {
        Comment oldComment = commentRepository.findOne(id);
        if (newComment.getContent() != null)
            oldComment.setContent(newComment.getContent());
        commentRepository.save(oldComment);
    }

    /**
     * @param id of the comment that will be deleted
     * @should invoke delete method of comment repository with given id
     */
    @Override
    public void deleteComment(int id) {
        commentRepository.delete(id);
    }
}
