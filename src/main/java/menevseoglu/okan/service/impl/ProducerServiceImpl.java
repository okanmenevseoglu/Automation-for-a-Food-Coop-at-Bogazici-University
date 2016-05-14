package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Producer;
import menevseoglu.okan.repository.ProducerRepository;
import menevseoglu.okan.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the producer operations.
 */
@Service
@Transactional
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    ProducerRepository producerRepository;

    /**
     * @return Iterable Producer object
     * @should invoke findAll method of producer repository
     * @should return what producer repository returns
     */
    @Override
    public Iterable<Producer> getProducers() {
        return producerRepository.findAll();
    }

    /**
     * @param id of the producer
     * @return Producer object with the given id
     * @should invoke findOne method of producer repository with given id
     * @should return what producer repository returns
     */
    @Override
    public Producer getProducer(short id) {
        return producerRepository.findOne(id);
    }

    /**
     * @param producer to be saved
     * @should invoke save method of producer repository
     */
    @Override
    public void saveProducer(Producer producer) {
        producerRepository.save(producer);
    }

    /**
     * @param id          of the producer that will be updated
     * @param newProducer to represent new values
     * @should invoke save method of producer repository with given id and new producer data
     * @should invoke save method of producer repository even if at least one data is null
     */
    @Override
    public void updateProducer(short id, Producer newProducer) {
        Producer oldProducer = producerRepository.findOne(id);
        if (newProducer.getFirstName() != null)
            oldProducer.setFirstName(newProducer.getFirstName());

        if (newProducer.getLastName() != null)
            oldProducer.setLastName(newProducer.getLastName());

        if (newProducer.getCompanyName() != null)
            oldProducer.setCompanyName(newProducer.getCompanyName());

        if (newProducer.getDescription() != null)
            oldProducer.setDescription(newProducer.getDescription());

        if (newProducer.getPhone() != null)
            oldProducer.setPhone(newProducer.getPhone());

        if (newProducer.getEmail() != null)
            oldProducer.setEmail(newProducer.getEmail());

        if (newProducer.getAddress() != null)
            oldProducer.setAddress(newProducer.getAddress());

        if (newProducer.getCity() != null)
            oldProducer.setCity(newProducer.getCity());

        if (newProducer.getLatitude() != 0)
            oldProducer.setLatitude(newProducer.getLatitude());

        if (newProducer.getLongitude() != 0)
            oldProducer.setLongitude(newProducer.getLongitude());
        producerRepository.save(oldProducer);
    }

    /**
     * @param id of the producer that will be deleted
     * @should invoke delete method of producer repository with given id
     */
    @Override
    public void deleteProducer(short id) throws RuntimeException {
        producerRepository.delete(id);
    }
}
