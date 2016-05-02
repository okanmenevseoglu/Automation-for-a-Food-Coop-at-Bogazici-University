package menevseoglu.okan.controller;

import menevseoglu.okan.model.Faq;
import menevseoglu.okan.service.QandAService;
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
public class QandAController {
    @Autowired
    QandAService qandAService;

    @RequestMapping(value = "/QandA/addNewQandA", method = RequestMethod.POST)
    public void addNewQandA(@Valid @RequestBody Faq faq) {
        qandAService.addNewQandA(faq);
    }
}
