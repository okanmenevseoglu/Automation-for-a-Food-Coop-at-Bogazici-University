package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Producer;
import menevseoglu.okan.repository.ProducerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the producer service operations.
 */
public class ProducerServiceImplTest {

    @Mock
    ProducerRepository producerRepository;

    @Mock
    private ArrayList<Producer> producerList;

    @Mock
    private Producer producer;

    @InjectMocks
    ProducerServiceImpl producerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of producer repository
     * @see ProducerServiceImpl#getProducers()
     */
    @Test
    public void getProducers_shouldInvokeFindAllMethodOfProducerRepository() throws Exception {
        producerService.getProducers();
        verify(producerRepository, times(1)).findAll();
    }

    /**
     * @verifies return what producer repository returns
     * @see ProducerServiceImpl#getProducers()
     */
    @Test
    public void getProducers_shouldReturnWhatProducerRepositoryReturns() throws Exception {
        when(producerRepository.findAll()).thenReturn(producerList);
        assertEquals(producerService.getProducers(), producerList);
    }

    /**
     * @verifies invoke findOne method of producer repository with given id
     * @see ProducerServiceImpl#getProducer(short)
     */
    @Test
    public void getProducer_shouldInvokeFindOneMethodOfProducerRepositoryWithGivenId() throws Exception {
        producerService.getProducer(anyShort());
        verify(producerRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what producer repository returns
     * @see ProducerServiceImpl#getProducer(short)
     */
    @Test
    public void getProducer_shouldReturnWhatProducerRepositoryReturns() throws Exception {
        when(producerRepository.findOne(anyShort())).thenReturn(producer);
        assertEquals(producerService.getProducer((short) 1), producer);
    }

    /**
     * @verifies invoke save method of producer repository
     * @see ProducerServiceImpl#saveProducer(menevseoglu.okan.model.Producer)
     */
    @Test
    public void saveProducer_shouldInvokeSaveMethodOfProducerRepository() throws Exception {
        producerService.saveProducer(producer);
        verify(producerRepository, times(1)).save(producer);
    }

    /**
     * @verifies invoke save method of producer repository with given id and new producer data
     * @see ProducerServiceImpl#updateProducer(short, menevseoglu.okan.model.Producer)
     */
    @Test
    public void updateProducer_shouldInvokeSaveMethodOfProducerRepositoryWithGivenIdAndNewProducerData() throws Exception {
        producerService.updateProducer(anyShort(), producer);
        verify(producerRepository, times(1)).findOne(anyShort());
        verify(producerRepository, times(1)).save(producerRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of producer repository even if at least one data is null
     * @see ProducerServiceImpl#updateProducer(short, menevseoglu.okan.model.Producer)
     */
    @Test
    public void updateProducer_shouldInvokeSaveMethodOfProducerRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        producer.setFirstName(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setLastName(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setCompanyName(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setDescription(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setPhone(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setEmail(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setAddress(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setCity(null);
        producerService.updateProducer(anyShort(), producer);
        producer.setLatitude(0);
        producerService.updateProducer(anyShort(), producer);
        producer.setLongitude(0);
        producerService.updateProducer(anyShort(), producer);
        verify(producerRepository, times(10)).findOne(anyShort());
        verify(producerRepository, times(10)).save(producerRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke delete method of producer repository with given id
     * @see ProducerServiceImpl#deleteProducer(short)
     */
    @Test
    public void deleteProducer_shouldInvokeDeleteMethodOfProducerRepositoryWithGivenId() throws Exception {
        producerService.deleteProducer(anyShort());
        verify(producerRepository, times(1)).delete(anyShort());
    }
}
