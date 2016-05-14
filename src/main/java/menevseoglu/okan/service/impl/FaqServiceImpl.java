package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.repository.FaqRepository;
import menevseoglu.okan.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the faq operations.
 */
@Service
@Transactional
public class FaqServiceImpl implements FaqService {

    @Autowired
    FaqRepository faqRepository;

    /**
     * @return Iterable Faq object
     * @should invoke findAll method of faq repository
     * @should return what faq repository returns
     */
    @Override
    public Iterable<Faq> getFaqs() {
        return faqRepository.findAll();
    }

    /**
     * @param id of the faq
     * @return Faq object with the given id
     * @should invoke findOne method of faq repository with given id
     * @should return what faq repository returns
     */
    @Override
    public Faq getFaq(short id) {
        return faqRepository.findOne(id);
    }

    /**
     * @param faq to be saved
     * @should invoke save method of faq repository
     */
    @Override
    public void saveFaq(Faq faq) {
        faqRepository.save(faq);
    }

    /**
     * @param id     of the faq that will be updated
     * @param newFaq to represent updated values
     * @should invoke save method of faq repository with given id and new faq data
     * @should invoke save method of faq repository even if at least one data is null
     */
    @Override
    public void updateFaq(short id, Faq newFaq) {
        Faq oldFaq = faqRepository.findOne(id);
        if (newFaq.getQuestion() != null)
            oldFaq.setQuestion(newFaq.getQuestion());
        if (newFaq.getAnswer() != null)
            oldFaq.setAnswer(newFaq.getAnswer());
        faqRepository.save(oldFaq);
    }

    /**
     * @param id of the faq that will be deleted
     * @should invoke delete method of faq repository with given id
     */
    @Override
    public void deleteFaq(short id) {
        faqRepository.delete(id);
    }
}
