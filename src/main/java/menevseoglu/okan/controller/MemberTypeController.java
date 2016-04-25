package menevseoglu.okan.controller;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by okanm on 21.04.2016.
 */
@RestController
public class MemberTypeController {
    @Autowired
    MemberTypeService memberTypeService;

    @RequestMapping(value = "/memberTypes", method = RequestMethod.GET)
    public Iterable<MemberType> showAllMemberTypes() {
        return memberTypeService.findAll();
    }

    @RequestMapping(value = "/memberTypes/{memberTypeName}", method = RequestMethod.GET)
    public MemberType findMemberTypeByName(@PathVariable("memberTypeName") String name) {
        return memberTypeService.findMemberTypeByName(name);
    }

    @RequestMapping(value = "/memberTypes/addNewMemberType", method = RequestMethod.POST)
    public void saveMemberType(@RequestBody MemberType memberType) {
        memberTypeService.addNewMemberType(memberType);
    }
}
