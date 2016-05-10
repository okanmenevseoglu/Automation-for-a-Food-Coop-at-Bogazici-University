package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PackageType;
import menevseoglu.okan.repository.PackageTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the package type service operations.
 */
public class PackageTypeServiceImplTest {

    @Mock
    PackageTypeRepository packageTypeRepository;

    @InjectMocks
    PackageTypeServiceImpl packageTypeService;

    @Mock
    private ArrayList<PackageType> packageTypeList;

    @Mock
    private PackageType packageType;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of package type repository
     * @see PackageTypeServiceImpl#getPackageTypes()
     */
    @Test
    public void getPackageTypes_shouldInvokeFindAllMethodOfPackageTypeRepository() throws Exception {
        packageTypeService.getPackageTypes();
        verify(packageTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what package type repository returns
     * @see PackageTypeServiceImpl#getPackageTypes()
     */
    @Test
    public void getPackageTypes_shouldReturnWhatPackageTypeRepositoryReturns() throws Exception {
        when(packageTypeRepository.findAll()).thenReturn(packageTypeList);
        assertEquals(packageTypeService.getPackageTypes(), packageTypeList);
    }

    /**
     * @verifies invoke findOne method of package type repository with given id
     * @see PackageTypeServiceImpl#getPackageType(short)
     */
    @Test
    public void getPackageType_shouldInvokeFindOneMethodOfPackageTypeRepositoryWithGivenId() throws Exception {
        packageTypeService.getPackageType(anyShort());
        verify(packageTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what package type repository returns
     * @see PackageTypeServiceImpl#getPackageType(short)
     */
    @Test
    public void getPackageType_shouldReturnWhatPackageTypeRepositoryReturns() throws Exception {
        when(packageTypeRepository.findOne(anyShort())).thenReturn(packageType);
        assertEquals(packageTypeService.getPackageType((short) 1), packageType);
    }

    /**
     * @verifies invoke save method of package type repository
     * @see PackageTypeServiceImpl#savePackageType(menevseoglu.okan.model.PackageType)
     */
    @Test
    public void savePackageType_shouldInvokeSaveMethodOfPackageTypeRepository() throws Exception {
        packageTypeService.savePackageType(packageType);
        verify(packageTypeRepository, times(1)).save(packageType);
    }

    /**
     * @verifies invoke delete method of package type repository with given id
     * @see PackageTypeServiceImpl#deletePackageType(short)
     */
    @Test
    public void deletePackageType_shouldInvokeDeleteMethodOfPackageTypeRepositoryWithGivenId() throws Exception {
        packageTypeService.deletePackageType(anyShort());
        verify(packageTypeRepository, times(1)).delete(anyShort());
    }
}
