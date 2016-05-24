package menevseoglu.okan.controller;

import menevseoglu.okan.model.Post;
import menevseoglu.okan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the post operations.
 */
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Post> getPosts() {
        return postService.getPosts();
    }

    @RequestMapping(value = "/getByPostTypeName/{name}", method = RequestMethod.GET)
    public Iterable<Post> getPostsByPostTypeName(@PathVariable("name") String name) {
        return postService.getPostsByPostTypeName(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable("id") int id) {
        return postService.getPost(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPost(@Valid @RequestBody Post post) {
        postService.savePost(post);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updatePost(@PathVariable("id") int id, @RequestBody Post newPost) {
        postService.updatePost(id, newPost);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable("id") int id) {
        postService.deletePost(id);
    }
}
