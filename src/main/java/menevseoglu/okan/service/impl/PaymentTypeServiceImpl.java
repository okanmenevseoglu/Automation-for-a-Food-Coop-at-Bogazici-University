package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.PaymentType;
import menevseoglu.okan.repository.PaymentTypeRepository;
import menevseoglu.okan.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

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
     * @should invoke findAll method of payment type repository
     * @should return what payment type repository returns
     */
    @Override
    public Iterable<PaymentType> getPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    /**
     * @param id of the payment type
     * @return PaymentType object with the given id
     * @should invoke findOne method of payment type repository with given id
     * @should return what payment type repository returns
     */
    @Override
    public PaymentType getPaymentType(short id) {
        return paymentTypeRepository.findOne(id);
    }

    /**
     * @param paymentType to be saved
     * @should invoke save method of payment type repository
     */
    @Override
    public void savePaymentType(PaymentType paymentType) {
        paymentTypeRepository.save(paymentType);
    }

    /**
     * @param id of the payment type that will be deleted
     * @should invoke delete method of payment type repository with given id
     */
    @Override
    public void deletePaymentType(short id) {
        PaymentType paymentType = paymentTypeRepository.findOne(id);
        if (paymentType == null)
            throw new EntityNotFoundException("Böyle bir ödeme tipi bulunamadı.");
        if (!(paymentType.getName().equalsIgnoreCase("nakit") || paymentType.getName().equalsIgnoreCase("kredi kartı")))
            paymentTypeRepository.delete(id);
        else
            throw new RuntimeException("Bu ödeme tipi silinemez!: " + paymentType.getName());
    }
}
