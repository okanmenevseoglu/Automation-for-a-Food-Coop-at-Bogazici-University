package menevseoglu.okan.service;

import menevseoglu.okan.model.Work;

/**
 * This class is the abstract representation of the service layer for the work operations.
 */
public interface WorkService {

    Iterable<Work> getWorks();

    Work getWork(int id);

    void saveWork(Work work);

    void updateWork(int id, Work newWork);

    void deleteWork(int id);
}
