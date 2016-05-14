package menevseoglu.okan.service;

import menevseoglu.okan.model.Producer;

/**
 * This class is the abstract representation of the service layer for the producer operations.
 */
public interface ProducerService {

    Iterable<Producer> getProducers();

    Producer getProducer(short id);

    void saveProducer(Producer producer);

    void updateProducer(short id, Producer newProducer);

    void deleteProducer(short id);
}
