package menevseoglu.okan.controller;

import menevseoglu.okan.model.Sale;
import menevseoglu.okan.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the sale operations.
 */
@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Sale> getSales() {
        return saleService.getSales();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sale getSale(@PathVariable("id") int id) {
        return saleService.getSale(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addSale(@Valid @RequestBody Sale sale) {
        saleService.saveSale(sale);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteSale(@PathVariable("id") int id) {
        saleService.deleteSale(id);
    }
}
