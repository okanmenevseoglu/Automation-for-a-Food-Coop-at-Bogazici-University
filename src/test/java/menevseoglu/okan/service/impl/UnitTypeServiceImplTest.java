package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.UnitType;
import menevseoglu.okan.repository.UnitTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the unit type service operations.
 */
public class UnitTypeServiceImplTest {

    @Mock
    UnitTypeRepository unitTypeRepository;

    @Mock
    private ArrayList<UnitType> unitTypeList;

    @Mock
    private UnitType unitType;

    @InjectMocks
    UnitTypeServiceImpl unitTypeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of unit type repository
     * @see UnitTypeServiceImpl#getUnitTypes()
     */
    @Test
    public void getUnitTypes_shouldInvokeFindAllMethodOfUnitTypeRepository() throws Exception {
        unitTypeService.getUnitTypes();
        verify(unitTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what unit type repository returns
     * @see UnitTypeServiceImpl#getUnitTypes()
     */
    @Test
    public void getUnitTypes_shouldReturnWhatUnitTypeRepositoryReturns() throws Exception {
        when(unitTypeRepository.findAll()).thenReturn(unitTypeList);
        assertEquals(unitTypeService.getUnitTypes(), unitTypeList);
    }

    /**
     * @verifies invoke findOne method of unit type repository with given id
     * @see UnitTypeServiceImpl#getUnitType(short)
     */
    @Test
    public void getUnitType_shouldInvokeFindOneMethodOfUnitTypeRepositoryWithGivenId() throws Exception {
        unitTypeService.getUnitType(anyShort());
        verify(unitTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what unit type repository returns
     * @see UnitTypeServiceImpl#getUnitType(short)
     */
    @Test
    public void getUnitType_shouldReturnWhatUnitTypeRepositoryReturns() throws Exception {
        when(unitTypeRepository.findOne(anyShort())).thenReturn(unitType);
        assertEquals(unitTypeService.getUnitType((short) 1), unitType);
    }

    /**
     * @verifies invoke save method of unit type repository
     * @see UnitTypeServiceImpl#saveUnitType(menevseoglu.okan.model.UnitType)
     */
    @Test
    public void saveUnitType_shouldInvokeSaveMethodOfUnitTypeRepository() throws Exception {
        unitTypeService.saveUnitType(unitType);
        verify(unitTypeRepository, times(1)).save(unitType);
    }

    /**
     * @verifies invoke delete method of unit type repository with given id
     * @see UnitTypeServiceImpl#deleteUnitType(short)
     */
    @Test
    public void deleteUnitType_shouldInvokeDeleteMethodOfUnitTypeRepositoryWithGivenId() throws Exception {
        unitTypeService.deleteUnitType(anyShort());
        verify(unitTypeRepository, times(1)).delete(anyShort());
    }
}
