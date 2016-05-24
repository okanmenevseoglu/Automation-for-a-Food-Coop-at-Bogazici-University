package menevseoglu.okan.controller;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the member type operations.
 */
@RestController
@RequestMapping("/memberTypes")
public class MemberTypeController {

    @Autowired
    MemberTypeService memberTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<MemberType> getMemberTypes() {
        return memberTypeService.getMemberTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MemberType getMemberType(@PathVariable("id") short id) {
        return memberTypeService.getMemberType(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public MemberType getMemberType(@PathVariable("name") String name) {
        return memberTypeService.getMemberTypeByName(name);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void saveMemberType(@Valid @RequestBody MemberType memberType) {
        memberTypeService.saveMemberType(memberType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteMemberType(@PathVariable("id") short id) {
        memberTypeService.deleteMemberType(id);
    }
}
