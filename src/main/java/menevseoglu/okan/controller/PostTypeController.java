package menevseoglu.okan.controller;

import menevseoglu.okan.model.PostType;
import menevseoglu.okan.service.PostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the post type operations.
 */
@RestController
@RequestMapping(value = "/postTypes")
public class PostTypeController {

    @Autowired
    PostTypeService postTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<PostType> getPostTypes() {
        return postTypeService.getPostTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PostType getPostType(@PathVariable("id") short id) {
        return postTypeService.getPostType(id);
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public PostType getPostType(@PathVariable("name") String name) {
        return postTypeService.getPostTypeByName(name);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPostType(@Valid @RequestBody PostType postType) {
        postTypeService.savePostType(postType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePostType(@PathVariable("id") short id) {
        postTypeService.deletePostType(id);
    }
}
