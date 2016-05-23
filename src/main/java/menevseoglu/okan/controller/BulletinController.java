package menevseoglu.okan.controller;

import menevseoglu.okan.model.Bulletin;
import menevseoglu.okan.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addBulletin(@RequestBody Bulletin bulletin) {
        bulletinService.saveBulletin(bulletin);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateBulletin(@PathVariable("id") short id, @RequestBody Bulletin newBulletin) {
        bulletinService.updateBulletin(id, newBulletin);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteBulletin(@PathVariable("id") short id) {
        bulletinService.deleteBulletin(id);
    }
}