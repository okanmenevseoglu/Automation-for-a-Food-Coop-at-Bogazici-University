package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PaymentType;
import menevseoglu.okan.repository.PaymentTypeRepository;
import menevseoglu.okan.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the payment type operations.
 */
@Service
@Transactional
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    /**
     * @return Iterable PaymentType object
     * @should get all the payment types
     */
    @Override
    public Iterable<PaymentType> getPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    /**
     * @param id of the payment type
     * @return PaymentType object with the given id
     * @should get the payment type with given id
     */
    @Override
    public PaymentType getPaymentType(short id) {
        return paymentTypeRepository.findOne(id);
    }

    /**
     * @param paymentType to be saved
     * @should save the given payment type to the database
     */
    @Override
    public void savePaymentType(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);
    }

    /**
     * @param id of the payment type that will be deleted
     * @should delete the payment type with given id
     */
    @Override
    public void deletePaymentType(short id) {
        paymentTypeRepository.delete(id);
    }
}
