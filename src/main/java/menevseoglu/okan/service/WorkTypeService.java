package menevseoglu.okan.service;

import menevseoglu.okan.model.WorkType;

/**
 * This class is the abstract representation of the service layer for the work type operations.
 */
public interface WorkTypeService {

    Iterable<WorkType> getWorkypes();

    WorkType getWorkType(short id);

    void saveWorkType(WorkType workType);

    void deleteWorkType(short id);
}
