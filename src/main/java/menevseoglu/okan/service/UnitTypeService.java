package menevseoglu.okan.service;

import menevseoglu.okan.model.UnitType;

/**
 * This class is the abstract representation of the service layer for the unit type operations.
 */
public interface UnitTypeService {

    Iterable<UnitType> getUnitTypes();

    UnitType getUnitType(short id);

    void saveUnitType(UnitType unitType);

    void deleteUnitType(short id);
}
