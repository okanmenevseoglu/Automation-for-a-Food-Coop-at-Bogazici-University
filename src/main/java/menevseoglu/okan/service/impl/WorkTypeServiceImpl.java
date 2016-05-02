package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.WorkType;
import menevseoglu.okan.repository.WorkTypeRepository;
import menevseoglu.okan.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the work type operations.
 */
@Service
@Transactional
public class WorkTypeServiceImpl implements WorkTypeService {

    @Autowired
    WorkTypeRepository workTypeRepository;

    /**
     * @return Iterable WorkType object
     * @should get all the work types
     */
    @Override
    public Iterable<WorkType> getWorkypes() {
        return workTypeRepository.findAll();
    }

    /**
     * @param id of the work type
     * @return WorkType object with the given id
     * @should get the work type with given id
     */
    @Override
    public WorkType getWorkType(short id) {
        return workTypeRepository.findOne(id);
    }

    /**
     * @param workType to be saved
     * @should save the given work type to the database
     */
    @Override
    public void saveWorkType(WorkType workType) {
        workTypeRepository.save(workType);
    }

    /**
     * @param id of the work type that will be deleted
     * @should delete the work type with given id
     */
    @Override
    public void deleteWorkType(short id) {
        workTypeRepository.delete(id);
    }
}
