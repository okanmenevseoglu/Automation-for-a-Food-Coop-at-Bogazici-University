package menevseoglu.okan.service;

import menevseoglu.okan.model.MemberType;

/**
 * This class is the abstract representation of the service layer for the member type operations.
 */
public interface MemberTypeService {

    Iterable<MemberType> getMemberTypes();

    MemberType getMemberType(short id);

    MemberType getMemberTypeByName(String name);

    void saveMemberType(MemberType memberType);

    void deleteMemberType(short id);
}
