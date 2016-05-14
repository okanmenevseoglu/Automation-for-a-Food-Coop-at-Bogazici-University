package menevseoglu.okan.controller;

import menevseoglu.okan.model.Producer;
import menevseoglu.okan.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the producer operations.
 */
@RestController
@RequestMapping(value = "/producers")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Producer> getProducers() {
        return producerService.getProducers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Producer getProducer(@PathVariable("id") short id) {
        return producerService.getProducer(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProducer(@Valid @RequestBody Producer producer) {
        producerService.saveProducer(producer);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateProducer(@PathVariable("id") short id, @RequestBody Producer newProducer) {
        producerService.updateProducer(id, newProducer);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProducer(@PathVariable("id") short id) {
        producerService.deleteProducer(id);
    }
}
