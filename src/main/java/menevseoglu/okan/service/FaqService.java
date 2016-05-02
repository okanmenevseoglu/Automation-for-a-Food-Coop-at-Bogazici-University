package menevseoglu.okan.service;

import menevseoglu.okan.model.Faq;

/**
 * This class is the abstract representation of the service layer for the faq operations.
 */
public interface FaqService {

    Iterable<Faq> getFaqs();

    Faq getFaq(short id);

    void saveFaq(Faq faq);

    void updateFaq(short id, Faq newFaq);

    void deleteFaq(short id);
}
