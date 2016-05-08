package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.UnitType;
import menevseoglu.okan.repository.UnitTypeRepository;
import menevseoglu.okan.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the unit type operations.
 */
@Service
@Transactional
public class UnitTypeServiceImpl implements UnitTypeService {

    @Autowired
    UnitTypeRepository unitTypeRepository;

    /**
     * @return Iterable UnitType object
     * @should invoke findAll method of unit type repository
     * @should return what unit type repository returns
     */
    @Override
    public Iterable<UnitType> getUnitTypes() {
        return unitTypeRepository.findAll();
    }

    /**
     * @param id of the unit type
     * @return UnitType object with the given id
     * @should invoke findOne method of unit type repository with given id
     * @should return what unit type repository returns
     */
    @Override
    public UnitType getUnitType(short id) {
        return unitTypeRepository.findOne(id);
    }

    /**
     * @param unitType to be saved
     * @should invoke save method of unit type repository
     */
    @Override
    public void saveUnitType(UnitType unitType) {
        unitTypeRepository.save(unitType);
    }

    /**
     * @param id of the unit type that will be deleted
     * @should invoke delete method of unit type repository with given id
     */
    @Override
    public void deleteUnitType(short id) {
        unitTypeRepository.delete(id);
    }
}
