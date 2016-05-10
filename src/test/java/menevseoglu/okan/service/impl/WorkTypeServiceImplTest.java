package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.WorkType;
import menevseoglu.okan.repository.WorkTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the work type service operations.
 */
public class WorkTypeServiceImplTest {

    @Mock
    WorkTypeRepository workTypeRepository;

    @InjectMocks
    WorkTypeServiceImpl workTypeService;

    @Mock
    private ArrayList<WorkType> workTypeList;

    @Mock
    private WorkType workType;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of work type repository
     * @see WorkTypeServiceImpl#getWorkTypes()
     */
    @Test
    public void getWorkTypes_shouldInvokeFindAllMethodOfWorkTypeRepository() throws Exception {
        workTypeService.getWorkTypes();
        verify(workTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what work type repository returns
     * @see WorkTypeServiceImpl#getWorkTypes()
     */
    @Test
    public void getWorkTypes_shouldReturnWhatWorkTypeRepositoryReturns() throws Exception {
        when(workTypeRepository.findAll()).thenReturn(workTypeList);
        assertEquals(workTypeService.getWorkTypes(), workTypeList);
    }

    /**
     * @verifies invoke findOne method of work type repository with given id
     * @see WorkTypeServiceImpl#getWorkType(short)
     */
    @Test
    public void getWorkType_shouldInvokeFindOneMethodOfWorkTypeRepositoryWithGivenId() throws Exception {
        workTypeService.getWorkType(anyShort());
        verify(workTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what work type repository returns
     * @see WorkTypeServiceImpl#getWorkType(short)
     */
    @Test
    public void getWorkType_shouldReturnWhatWorkTypeRepositoryReturns() throws Exception {
        when(workTypeRepository.findOne(anyShort())).thenReturn(workType);
        assertEquals(workTypeService.getWorkType((short) 1), workType);
    }

    /**
     * @verifies invoke save method of work type repository
     * @see WorkTypeServiceImpl#saveWorkType(menevseoglu.okan.model.WorkType)
     */
    @Test
    public void saveWorkType_shouldInvokeSaveMethodOfWorkTypeRepository() throws Exception {
        workTypeService.saveWorkType(workType);
        verify(workTypeRepository, times(1)).save(workType);
    }

    /**
     * @verifies invoke delete method of work type repository with given id
     * @see WorkTypeServiceImpl#deleteWorkType(short)
     */
    @Test
    public void deleteWorkType_shouldInvokeDeleteMethodOfWorkTypeRepositoryWithGivenId() throws Exception {
        workTypeService.deleteWorkType(anyShort());
        verify(workTypeRepository, times(1)).delete(anyShort());
    }
}
