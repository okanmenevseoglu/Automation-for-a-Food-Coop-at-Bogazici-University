package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.repository.MemberTypeRepository;
import menevseoglu.okan.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the member type operations.
 */
@Service
@Transactional
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    MemberTypeRepository memberTypeRepository;

    /**
     * @return Iterable MemberType object
     * @should get all the bulletins
     */
    @Override
    public Iterable<MemberType> getMemberTypes() {
        return memberTypeRepository.findAll();
    }

    /**
     * @param id of the member type
     * @return MemberType object with the given id
     * @should get the member type with given id
     */
    @Override
    public MemberType getMemberType(short id) {
        return memberTypeRepository.findOne(id);
    }

    /**
     * @param memberType to be saved
     * @should save the given member type to the database
     */
    @Override
    public void saveMemberType(MemberType memberType) {
        memberTypeRepository.save(memberType);
    }

    /**
     * @param id of the member type that will be deleted
     * @should delete the member type with given id
     */
    @Override
    public void deleteMemberType(short id) {
        MemberType memberType = memberTypeRepository.findOne(id);
        if (!(memberType.getName().equals("ROLE_ADMIN") || memberType.getName().equals("ROLE_STOCKER")
                || memberType.getName().equals("ROLE_SELLER") || memberType.getName().equals("ROLE_MEMBER")))
            memberTypeRepository.delete(id);
        else
            throw new RuntimeException("You can't delete this member type!: " + memberType.getName());
    }
}
