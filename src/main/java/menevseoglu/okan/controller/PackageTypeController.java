package menevseoglu.okan.controller;

import menevseoglu.okan.model.PackageType;
import menevseoglu.okan.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the package type operations.
 */
@RestController
@RequestMapping(value = "/packageTypes")
public class PackageTypeController {

    @Autowired
    PackageTypeService packageTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<PackageType> getPackageTypes() {
        return packageTypeService.getPackageTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PackageType getPackageType(@PathVariable("id") short id) {
        return packageTypeService.getPackageType(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addPackageType(@Valid @RequestBody PackageType packageType) {
        packageTypeService.savePackageType(packageType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deletePackageType(@PathVariable("id") short id) {
        packageTypeService.deletePackageType(id);
    }
}
