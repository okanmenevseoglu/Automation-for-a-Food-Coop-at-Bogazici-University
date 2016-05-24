package menevseoglu.okan.controller;

import menevseoglu.okan.model.Comment;
import menevseoglu.okan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the comment operations.
 */
@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Comment> getComments() {
        return commentService.getComments();
    }

    @RequestMapping(value = "/getAllByProductId/{id}", method = RequestMethod.GET)
    public Iterable<Comment> getCommentsByProductId(@RequestParam("id") short id) {
        return commentService.getCommentsByProductId(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable("id") int id) {
        return commentService.getComment(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MEMBER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addComment(@Valid @RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateComment(@PathVariable("id") int id, @RequestBody Comment newComment) {
        commentService.updateComment(id, newComment);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("id") int id) {
        commentService.deleteComment(id);
    }
}
