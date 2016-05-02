package menevseoglu.okan.service;

import menevseoglu.okan.model.PackageType;

/**
 * This class is the abstract representation of the service layer for the package type operations.
 */
public interface PackageTypeService {

    Iterable<PackageType> getPackageTypes();

    PackageType getPackageType(short id);

    void savePackageType(PackageType packageType);

    void deletePackageType(short id);
}
