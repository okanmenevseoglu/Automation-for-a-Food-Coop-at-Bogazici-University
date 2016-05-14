package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Work;
import menevseoglu.okan.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the work service operations.
 */
public class WorkServiceImplTest {

    @Mock
    WorkRepository workRepository;

    @Mock
    private ArrayList<Work> workList;

    @Mock
    private Work work;

    @InjectMocks
    WorkServiceImpl workService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of work repository
     * @see WorkServiceImpl#getWorks()
     */
    @Test
    public void getWorks_shouldInvokeFindAllMethodOfWorkRepository() throws Exception {
        workService.getWorks();
        verify(workRepository, times(1)).findAll();
    }

    /**
     * @verifies return what work repository returns
     * @see WorkServiceImpl#getWorks()
     */
    @Test
    public void getWorks_shouldReturnWhatWorkRepositoryReturns() throws Exception {
        when(workRepository.findAll()).thenReturn(workList);
        assertEquals(workService.getWorks(), workList);
    }

    /**
     * @verifies invoke findOne method of work repository with given id
     * @see WorkServiceImpl#getWork
     */
    @Test
    public void getWork_shouldInvokeFindOneMethodOfWorkRepositoryWithGivenId() throws Exception {
        workService.getWork(anyInt());
        verify(workRepository, times(1)).findOne(anyInt());
    }

    /**
     * @verifies return what work repository returns
     * @see WorkServiceImpl#getWork
     */
    @Test
    public void getWork_shouldReturnWhatWorkRepositoryReturns() throws Exception {
        when(workRepository.findOne(anyInt())).thenReturn(work);
        assertEquals(workService.getWork(1), work);
    }

    /**
     * @verifies invoke save method of work repository
     * @see WorkServiceImpl#saveWork(menevseoglu.okan.model.Work)
     */
    @Test
    public void saveWork_shouldInvokeSaveMethodOfWorkRepository() throws Exception {
        workService.saveWork(work);
        verify(workRepository, times(1)).save(work);
    }

    /**
     * @verifies invoke save method of work repository with given id and new work data
     * @see WorkServiceImpl#updateWork(int, menevseoglu.okan.model.Work)
     */
    @Test
    public void updateWork_shouldInvokeSaveMethodOfWorkRepositoryWithGivenIdAndNewWorkData() throws Exception {
        workService.updateWork(anyInt(), work);
        verify(workRepository, times(1)).findOne(anyInt());
        verify(workRepository, times(1)).save(workRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke save method of work repository even if at least one data is null
     * @see WorkServiceImpl#updateWork(int, menevseoglu.okan.model.Work)
     */
    @Test
    public void updateWork_shouldInvokeSaveMethodOfWorkRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        work.setDescription(null);
        workService.updateWork(anyInt(), work);
        work.setDateOfCreation(null);
        workService.updateWork(anyInt(), work);
        work.setDateOfWork(null);
        workService.updateWork(anyInt(), work);
        work.setMember(null);
        workService.updateWork(anyInt(), work);
        work.setWorkType(null);
        workService.updateWork(anyInt(), work);
        verify(workRepository, times(5)).findOne(anyInt());
        verify(workRepository, times(5)).save(workRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke delete method of work repository with given id
     * @see WorkServiceImpl#deleteWork
     */
    @Test
    public void deleteWork_shouldInvokeDeleteMethodOfWorkRepositoryWithGivenId() throws Exception {
        workService.deleteWork(anyInt());
        verify(workRepository, times(1)).delete(anyInt());
    }
}
