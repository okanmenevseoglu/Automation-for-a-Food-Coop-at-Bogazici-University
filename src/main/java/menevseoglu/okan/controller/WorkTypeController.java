package menevseoglu.okan.controller;

import menevseoglu.okan.model.WorkType;
import menevseoglu.okan.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the work type operations.
 */
@RestController
@RequestMapping(value = "/workTypes")
public class WorkTypeController {

    @Autowired
    WorkTypeService workTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<WorkType> getWorkTypes() {
        return workTypeService.getWorkTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public WorkType getWorkType(@PathVariable("id") short id) {
        return workTypeService.getWorkType(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addWorkType(@Valid @RequestBody WorkType workType) {
        workTypeService.saveWorkType(workType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWorkType(@PathVariable("id") short id) {
        workTypeService.deleteWorkType(id);
    }
}
