package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.repository.MemberTypeRepository;
import menevseoglu.okan.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
     * @should invoke findAll method of member type repository
     * @should return what member type repository returns
     */
    @Override
    public Iterable<MemberType> getMemberTypes() {
        return memberTypeRepository.findAll();
    }

    /**
     * @param id of the member type
     * @return MemberType object with the given id
     * @should invoke findOne method of member type repository with given id
     * @should return what member type repository returns
     */
    @Override
    public MemberType getMemberType(short id) {
        return memberTypeRepository.findOne(id);
    }

    @Override
    public MemberType getMemberTypeByName(String name) {
        return memberTypeRepository.findOneByName(name);
    }

    /**
     * @param memberType to be saved
     * @should invoke save method of member type repository
     */
    @Override
    public void saveMemberType(MemberType memberType) {
        memberTypeRepository.save(memberType);
    }

    /**
     * @param id of the member type that will be deleted
     * @throws RuntimeException if pre-defined member type is trying to be deleted
     * @should invoke delete method of member type repository with given id if member type is not pre-defined
     */
    @Override
    public void deleteMemberType(short id) {
        MemberType memberType = memberTypeRepository.findOne(id);
        if (memberType == null)
            throw new EntityNotFoundException("Böyle bir üye tipi bulunamadı.");
        if (!(memberType.getName().equals("ROLE_ADMIN") || memberType.getName().equals("ROLE_STOCKER")
                || memberType.getName().equals("ROLE_SELLER") || memberType.getName().equals("ROLE_MEMBER")))
            memberTypeRepository.delete(id);
        else
            throw new RuntimeException("Bu üye tipi silinemez!: " + memberType.getName());
    }
}
