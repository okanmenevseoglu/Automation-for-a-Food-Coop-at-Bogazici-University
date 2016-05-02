package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.repository.FaqRepository;
import menevseoglu.okan.service.QandAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by okanm on 29.04.2016.
 */
@Service
public class QandAServiceImpl implements QandAService {
    @Autowired
    FaqRepository faqRepository;

    @Override
    public void addNewQandA(Faq faq) {
        faqRepository.save(faq);
    }
}
