package menevseoglu.okan.controller;

import menevseoglu.okan.model.UnitType;
import menevseoglu.okan.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the unit type operations.
 */
@RestController
@RequestMapping(value = "/unitTypes")
public class UnitTypeController {

    @Autowired
    UnitTypeService unitTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<UnitType> getUnitTypes() {
        return unitTypeService.getUnitTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnitType getUnitType(@PathVariable("id") short id) {
        return unitTypeService.getUnitType(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STOCKER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUnitType(@Valid @RequestBody UnitType unitType) {
        unitTypeService.saveUnitType(unitType);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STOCKER')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUnitType(@PathVariable("id") short id) {
        unitTypeService.deleteUnitType(id);
    }
}
