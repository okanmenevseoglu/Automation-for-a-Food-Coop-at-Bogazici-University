package menevseoglu.okan.controller;

import menevseoglu.okan.model.Bulletin;
import menevseoglu.okan.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the bulletin operations.
 */
@RestController
@RequestMapping(value = "/bulletins")
public class BulletinController {

    @Autowired
    BulletinService bulletinService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Bulletin> getBulletins() {
        return bulletinService.getBulletins();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bulletin getBulletin(@PathVariable("id") short id) {
        return bulletinService.getBulletin(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBulletin(@Valid @RequestBody Bulletin bulletin) {
        bulletinService.saveBulletin(bulletin);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateBulletin(@PathVariable("id") short id, @RequestBody Bulletin newBulletin) {
        bulletinService.updateBulletin(id, newBulletin);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBulletin(@PathVariable("id") short id) {
        bulletinService.deleteBulletin(id);
    }
}
