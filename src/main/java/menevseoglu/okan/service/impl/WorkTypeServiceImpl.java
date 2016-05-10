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
     * @should invoke findAll method of work type repository
     * @should return what work type repository returns
     */
    @Override
    public Iterable<WorkType> getWorkTypes() {
        return workTypeRepository.findAll();
    }

    /**
     * @param id of the work type
     * @return WorkType object with the given id
     * @should invoke findOne method of work type repository with given id
     * @should return what work type repository returns
     */
    @Override
    public WorkType getWorkType(short id) {
        return workTypeRepository.findOne(id);
    }

    /**
     * @param workType to be saved
     * @should invoke save method of work type repository
     */
    @Override
    public void saveWorkType(WorkType workType) {
        workTypeRepository.save(workType);
    }

    /**
     * @param id of the work type that will be deleted
     * @should invoke delete method of work type repository with given id
     */
    @Override
    public void deleteWorkType(short id) {
        workTypeRepository.delete(id);
    }
}
