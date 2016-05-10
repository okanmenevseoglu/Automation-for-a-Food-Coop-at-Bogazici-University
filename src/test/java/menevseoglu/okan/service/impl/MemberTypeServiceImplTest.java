package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.MemberType;
import menevseoglu.okan.repository.MemberTypeRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the member type service operations.
 */
public class MemberTypeServiceImplTest {

    @Mock
    MemberTypeRepository memberTypeRepository;

    @Mock
    private ArrayList<MemberType> memberTypeList;

    @Mock
    private MemberType memberType;

    @InjectMocks
    MemberTypeServiceImpl memberTypeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of member type repository
     * @see MemberTypeServiceImpl#getMemberTypes()
     */
    @Test
    public void getMemberTypes_shouldInvokeFindAllMethodOfMemberTypeRepository() throws Exception {
        memberTypeService.getMemberTypes();
        verify(memberTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what member type repository returns
     * @see MemberTypeServiceImpl#getMemberTypes()
     */
    @Test
    public void getMemberTypes_shouldReturnWhatMemberTypeRepositoryReturns() throws Exception {
        when(memberTypeRepository.findAll()).thenReturn(memberTypeList);
        assertEquals(memberTypeService.getMemberTypes(), memberTypeList);
    }

    /**
     * @verifies invoke findOne method of member type repository with given id
     * @see MemberTypeServiceImpl#getMemberType(short)
     */
    @Test
    public void getMemberType_shouldInvokeFindOneMethodOfMemberTypeRepositoryWithGivenId() throws Exception {
        memberTypeService.getMemberType(anyShort());
        verify(memberTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what member type repository returns
     * @see MemberTypeServiceImpl#getMemberType(short)
     */
    @Test
    public void getMemberType_shouldReturnWhatMemberTypeRepositoryReturns() throws Exception {
        when(memberTypeRepository.findOne(anyShort())).thenReturn(memberType);
        assertEquals(memberTypeService.getMemberType((short) 1), memberType);
    }

    /**
     * @verifies invoke save method of member type repository
     * @see MemberTypeServiceImpl#saveMemberType(menevseoglu.okan.model.MemberType)
     */
    @Test
    public void saveMemberType_shouldInvokeSaveMethodOfMemberTypeRepository() throws Exception {
        memberTypeService.saveMemberType(memberType);
        verify(memberTypeRepository, times(1)).save(memberType);
    }


    /**
     * @throws RuntimeException if pre-defined member type is trying to be deleted
     * @verifies invoke delete method of member type repository with given id if member type is not pre-defined
     * @see MemberTypeServiceImpl#deleteMemberType(short)
     */
    @Test(expected = RuntimeException.class)
    public void deleteMemberType_shouldInvokeDeleteMethodOfMemberTypeRepositoryWithGivenIdIfMemberTypeIsNotPredefined() throws Exception {
        memberTypeService.deleteMemberType(anyShort());
        verify(memberTypeRepository, times(1)).delete(anyShort());
    }
}
