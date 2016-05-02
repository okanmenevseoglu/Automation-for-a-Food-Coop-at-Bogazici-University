package menevseoglu.okan.controller;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by okanm on 29.04.2016.
 */
@RestController
public class FaqController {
    @Autowired
    FaqService faqService;

    @RequestMapping(value = "/Faq/add", method = RequestMethod.POST)
    public void addFaq(@Valid @RequestBody Faq faq) {
        faqService.saveFaq(faq);
    }
}
