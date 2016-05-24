package menevseoglu.okan.service;

import menevseoglu.okan.model.Comment;

/**
 * This class is the abstract representation of the service layer for the comment operations.
 */
public interface CommentService {

    Iterable<Comment> getComments();

    Iterable<Comment> getCommentsByProductId(short id);

    Comment getComment(int id);

    void saveComment(Comment comment);

    void updateComment(int id, Comment newComment);

    void deleteComment(int id);
}
