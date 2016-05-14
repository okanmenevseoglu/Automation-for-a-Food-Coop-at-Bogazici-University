package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Work;
import menevseoglu.okan.repository.WorkRepository;
import menevseoglu.okan.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the work operations.
 */
@Service
@Transactional
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;

    /**
     * @return Iterable Work object
     * @should invoke findAll method of work repository
     * @should return what work repository returns
     */
    @Override
    public Iterable<Work> getWorks() {
        return workRepository.findAll();
    }

    /**
     * @param id of the work
     * @return Work object with the given id
     * @should invoke findOne method of work repository with given id
     * @should return what work repository returns
     */
    @Override
    public Work getWork(int id) {
        return workRepository.findOne(id);
    }

    /**
     * @param work to be saved
     * @should invoke save method of work repository
     */
    @Override
    public void saveWork(Work work) {
        workRepository.save(work);
    }

    /**
     * @param id      of the work that will be updated
     * @param newWork to represent new values
     * @should invoke save method of work repository with given id and new work data
     * @should invoke save method of work repository even if at least one data is null
     */
    @Override
    public void updateWork(int id, Work newWork) {
        Work oldWork = workRepository.findOne(id);
        if (newWork.getDescription() != null)
            oldWork.setDescription(newWork.getDescription());
        if (newWork.getDateOfWork() != null)
            oldWork.setDateOfWork(newWork.getDateOfWork());
        if (newWork.getWorkType() != null)
            oldWork.setWorkType(newWork.getWorkType());
        if (newWork.getMember() != null)
            oldWork.setMember(newWork.getMember());
        workRepository.save(oldWork);
    }

    /**
     * @param id of the work that will be deleted
     * @should invoke delete method of work repository with given id
     */
    @Override
    public void deleteWork(int id) {
        workRepository.delete(id);
    }
}
