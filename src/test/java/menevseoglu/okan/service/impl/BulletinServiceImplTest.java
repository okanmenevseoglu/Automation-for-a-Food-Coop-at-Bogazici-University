package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Bulletin;
import menevseoglu.okan.repository.BulletinRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the bulletin service operations.
 */
public class BulletinServiceImplTest {

    @Mock
    BulletinRepository bulletinRepository;

    @Mock
    private ArrayList<Bulletin> bulletinList;

    @Mock
    private Bulletin bulletin;

    @InjectMocks
    BulletinServiceImpl bulletinService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of bulletin repository
     * @see BulletinServiceImpl#getBulletins()
     */
    @Test
    public void getBulletins_shouldInvokeFindAllMethodOfBulletinRepository() throws Exception {
        bulletinService.getBulletins();
        verify(bulletinRepository, times(1)).findAll();
    }

    /**
     * @verifies return what bulletin repository returns
     * @see BulletinServiceImpl#getBulletins()
     */
    @Test
    public void getBulletins_shouldReturnWhatBulletinRepositoryReturns() throws Exception {
        when(bulletinRepository.findAll()).thenReturn(bulletinList);
        assertEquals(bulletinService.getBulletins(), bulletinList);
    }

    /**
     * @verifies invoke findOne method of bulletin repository with given id
     * @see BulletinServiceImpl#getBulletin(short)
     */
    @Test
    public void getBulletin_shouldInvokeFindOneMethodOfBulletinRepositoryWithGivenId() throws Exception {
        bulletinService.getBulletin(anyShort());
        verify(bulletinRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what bulletin repository returns
     * @see BulletinServiceImpl#getBulletin(short)
     */
    @Test
    public void getBulletin_shouldReturnWhatBulletinRepositoryReturns() throws Exception {
        when(bulletinRepository.findOne(anyShort())).thenReturn(bulletin);
        assertEquals(bulletinService.getBulletin((short) 1), bulletin);
    }

    /**
     * @verifies invoke save method of bulletin repository
     * @see BulletinServiceImpl#saveBulletin(menevseoglu.okan.model.Bulletin)
     */
    @Test
    public void saveBulletin_shouldInvokeSaveMethodOfBulletinRepository() throws Exception {
        bulletinService.saveBulletin(bulletin);
        verify(bulletinRepository, times(1)).save(bulletin);
    }

    /**
     * @verifies invoke save method of bulletin repository with given id and new bulletin data
     * @see BulletinServiceImpl#updateBulletin(short, menevseoglu.okan.model.Bulletin)
     */
    @Test
    public void updateBulletin_shouldInvokeSaveMethodOfBulletinRepositoryWithGivenIdAndNewBulletinData() throws Exception {
        bulletinService.updateBulletin(anyShort(), bulletin);
        verify(bulletinRepository, times(1)).findOne(anyShort());
        verify(bulletinRepository, times(1)).save(bulletinRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of bulletin repository even if at least one data is null
     * @see BulletinServiceImpl#updateBulletin(short, menevseoglu.okan.model.Bulletin)
     */
    @Test
    public void updateBulletin_shouldInvokeSaveMethodOfBulletinRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        bulletin.setName(null);
        bulletinService.updateBulletin(anyShort(), bulletin);
        bulletin.setUrl(null);
        bulletinService.updateBulletin(anyShort(), bulletin);
        bulletin.setDate(null);
        bulletinService.updateBulletin(anyShort(), bulletin);
        verify(bulletinRepository, times(3)).findOne(anyShort());
        verify(bulletinRepository, times(3)).save(bulletinRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke delete method of bulletin repository with given id
     * @see BulletinServiceImpl#deleteBulletin(short)
     */
    @Test
    public void deleteBulletin_shouldInvokeDeleteMethodOfBulletinRepositoryWithGivenId() throws Exception {
        bulletinService.deleteBulletin(anyShort());
        verify(bulletinRepository, times(1)).delete(anyShort());
    }
}
