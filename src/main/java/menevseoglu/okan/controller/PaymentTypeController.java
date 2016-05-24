package menevseoglu.okan.controller;

import menevseoglu.okan.model.PaymentType;
import menevseoglu.okan.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the payment type operations.
 */
@RestController
@RequestMapping("/paymentTypes")
public class PaymentTypeController {

    @Autowired
    PaymentTypeService paymentTypeService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<PaymentType> getPaymentTypes() {
        return paymentTypeService.getPaymentTypes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PaymentType getPaymentType(@PathVariable("id") short id) {
        return paymentTypeService.getPaymentType(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void savePaymentType(@Valid @RequestBody PaymentType paymentType) {
        paymentTypeService.savePaymentType(paymentType);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deletePaymentType(@PathVariable("id") short id) {
        paymentTypeService.deletePaymentType(id);
    }
}