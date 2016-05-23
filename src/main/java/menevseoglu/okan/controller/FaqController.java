package menevseoglu.okan.controller;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the faq operations.
 */
@RestController
@RequestMapping(value = "/faqs")
public class FaqController {

    @Autowired
    FaqService faqService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Faq> getFaqs() {
        return faqService.getFaqs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Faq getFaq(@PathVariable("id") short id) {
        return faqService.getFaq(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addFaq(@Valid @RequestBody Faq faq) {
        faqService.saveFaq(faq);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateFaq(@PathVariable("id") short id, @RequestBody Faq newFaq) {
        faqService.updateFaq(id, newFaq);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteFaq(@PathVariable("id") short id) {
        faqService.deleteFaq(id);
    }
}