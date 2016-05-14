package menevseoglu.okan.controller;

import menevseoglu.okan.model.Photo;
import menevseoglu.okan.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the photo operations.
 */
@RestController
@RequestMapping(value = "/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Photo> getPhotos() {
        return photoService.getPhotos();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Photo getPhoto(@PathVariable("id") int id) {
        return photoService.getPhoto(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPhoto(@Valid @RequestBody Photo photo) {
        photoService.savePhoto(photo);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updatePhoto(@PathVariable("id") int id, @RequestBody Photo newPhoto) {
        photoService.updatePhoto(id, newPhoto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePhoto(@PathVariable("id") int id) {
        photoService.deletePhoto(id);
    }
}
