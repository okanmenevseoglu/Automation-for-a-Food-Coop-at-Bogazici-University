package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PaymentType;
import menevseoglu.okan.repository.PaymentTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the payment type service operations.
 */
public class PaymentTypeServiceImplTest {

    @Mock
    PaymentTypeRepository paymentTypeRepository;

    @Mock
    private ArrayList<PaymentType> paymentTypeList;

    @Mock
    private PaymentType paymentType;

    @InjectMocks
    PaymentTypeServiceImpl paymentTypeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of payment type repository
     * @see PaymentTypeServiceImpl#getPaymentTypes()
     */
    @Test
    public void getPaymentTypes_shouldInvokeFindAllMethodOfPaymentTypeRepository() throws Exception {
        paymentTypeService.getPaymentTypes();
        verify(paymentTypeRepository, times(1)).findAll();
    }

    /**
     * @verifies return what payment type repository returns
     * @see PaymentTypeServiceImpl#getPaymentTypes()
     */
    @Test
    public void getPaymentTypes_shouldReturnWhatPaymentTypeRepositoryReturns() throws Exception {
        when(paymentTypeRepository.findAll()).thenReturn(paymentTypeList);
        assertEquals(paymentTypeService.getPaymentTypes(), paymentTypeList);
    }

    /**
     * @verifies invoke findOne method of payment type repository with given id
     * @see PaymentTypeServiceImpl#getPaymentType(short)
     */
    @Test
    public void getPaymentType_shouldInvokeFindOneMethodOfPaymentTypeRepositoryWithGivenId() throws Exception {
        paymentTypeService.getPaymentType(anyShort());
        verify(paymentTypeRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what payment type repository returns
     * @see PaymentTypeServiceImpl#getPaymentType(short)
     */
    @Test
    public void getPaymentType_shouldReturnWhatPaymentTypeRepositoryReturns() throws Exception {
        when(paymentTypeRepository.findOne(anyShort())).thenReturn(paymentType);
        assertEquals(paymentTypeService.getPaymentType((short) 1), paymentType);
    }

    /**
     * @verifies invoke save method of payment type repository
     * @see PaymentTypeServiceImpl#savePaymentType(menevseoglu.okan.model.PaymentType)
     */
    @Test
    public void savePaymentType_shouldInvokeSaveMethodOfPaymentTypeRepository() throws Exception {
        paymentTypeService.savePaymentType(paymentType);
        verify(paymentTypeRepository, times(1)).save(paymentType);
    }

    /**
     * @verifies invoke delete method of payment type repository with given id
     * @see PaymentTypeServiceImpl#deletePaymentType(short)
     */
    @Test(expected = RuntimeException.class)
    public void deletePaymentType_shouldInvokeDeleteMethodOfPaymentTypeRepositoryWithGivenId() throws Exception {
        paymentTypeService.deletePaymentType(anyShort());
        verify(paymentTypeRepository, times(1)).delete(anyShort());
    }
}
