package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PackageType;
import menevseoglu.okan.repository.PackageTypeRepository;
import menevseoglu.okan.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the package type operations.
 */
@Service
@Transactional
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    PackageTypeRepository packageTypeRepository;

    /**
     * @return Iterable PackageType object
     * @should invoke findAll method of package type repository
     * @should return what package type repository returns
     */
    @Override
    public Iterable<PackageType> getPackageTypes() {
        return packageTypeRepository.findAll();
    }

    /**
     * @param id of the package type
     * @return PackageType object with the given id
     * @should invoke findOne method of package type repository with given id
     * @should return what package type repository returns
     */
    @Override
    public PackageType getPackageType(short id) {
        return packageTypeRepository.findOne(id);
    }

    /**
     * @param packageType to be saved
     * @should invoke save method of package type repository
     */
    @Override
    public void savePackageType(PackageType packageType) {
        packageTypeRepository.save(packageType);
    }

    /**
     * @param id of the package type that will be deleted
     * @should invoke delete method of package type repository with given id
     */
    @Override
    public void deletePackageType(short id) {
        packageTypeRepository.delete(id);
    }
}
