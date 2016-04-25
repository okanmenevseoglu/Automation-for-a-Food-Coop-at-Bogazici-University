package menevseoglu.okan.service;

import menevseoglu.okan.model.MemberType;

/**
 * Created by okanm on 21.04.2016.
 */
public interface MemberTypeService {
    void addNewMemberType(MemberType memberType);

    MemberType findMemberTypeByName(String name);

    Iterable<MemberType> findAll();

    void delete(MemberType memberType);
}
