package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.repository.MemberTypeRepository;
import menevseoglu.okan.service.MemberService;
import menevseoglu.okan.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by okanm on 21.04.2016.
 */
@Service
public class MemberTypeServiceImpl implements MemberTypeService {
    @Autowired
    MemberTypeRepository memberTypeRepository;


    @Override
    public void addNewMemberType(MemberType memberType) {
        memberTypeRepository.save(memberType);
    }

    @Override
    public MemberType findMemberTypeByName(String name) {
        Iterable<MemberType> memberTypes = memberTypeRepository.findAll();
        for (MemberType memberType : memberTypes) {
            if (memberType.getName().equals(name))
                return memberType;
        }
        return null;
    }

    @Override
    public Iterable<MemberType> findAll() {
        return memberTypeRepository.findAll();
    }

    @Override
    public void delete(MemberType memberType) {
        memberTypeRepository.delete(memberType);
    }
}
