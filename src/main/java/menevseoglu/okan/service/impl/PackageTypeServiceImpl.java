package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PackageType;
import menevseoglu.okan.repository.PackageTypeRepository;
import menevseoglu.okan.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is the business layer of the package type operations.
 */
public class PackageTypeServiceImpl implements PackageTypeService {

    @Autowired
    PackageTypeRepository packageTypeRepository;

    @Override
    public Iterable<PackageType> getPackageTypes() {
        return packageTypeRepository.findAll();
    }

    @Override
    public PackageType getPackageType(short id) {
        return packageTypeRepository.findOne(id);
    }

    @Override
    public void savePackageType(PackageType packageType) {
        packageTypeRepository.save(packageType);
    }

    @Override
    public void deletePackageType(short id) {
        packageTypeRepository.delete(id);
    }
}
