package menevseoglu.okan.controller;

import menevseoglu.okan.model.Work;
import menevseoglu.okan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the work operations.
 */
@RestController
@RequestMapping(value = "/works")
public class WorkController {

    @Autowired
    WorkService workService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Work> getWorks() {
        return workService.getWorks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Work getWork(@PathVariable("id") short id) {
        return workService.getWork(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addWork(@Valid @RequestBody Work work) {
        workService.saveWork(work);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateWork(@PathVariable("id") short id, @RequestBody Work newWork) {
        workService.updateWork(id, newWork);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWork(@PathVariable("id") short id) {
        workService.deleteWork(id);
    }
}
