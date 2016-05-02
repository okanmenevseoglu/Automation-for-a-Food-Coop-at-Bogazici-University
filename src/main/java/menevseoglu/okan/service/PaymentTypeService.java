package menevseoglu.okan.service;

import menevseoglu.okan.model.PaymentType;

/**
 * This class is the abstract representation of the service layer for the payment type operations.
 */
public interface PaymentTypeService {

    Iterable<PaymentType> getPaymentTypes();

    PaymentType getPaymentType(short id);

    void savePaymentType(PaymentType paymentType);

    void deletePaymentType(short id);
}
