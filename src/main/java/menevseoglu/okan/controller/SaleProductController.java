package menevseoglu.okan.controller;

import menevseoglu.okan.model.SaleProduct;
import menevseoglu.okan.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the sale-product operations.
 */
@RestController
@RequestMapping(value = "/saleProducts")
public class SaleProductController {

    @Autowired
    SaleProductService saleProductService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<SaleProduct> getSaleProducts() {
        return saleProductService.getSaleProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SaleProduct getSaleProduct(@PathVariable("id") int id) {
        return saleProductService.getSaleProduct(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addSaleProduct(@Valid @RequestBody SaleProduct saleProduct) {
        saleProductService.saveSaleProduct(saleProduct);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateSaleProduct(@PathVariable("id") int id, @RequestBody SaleProduct newSaleProduct) {
        saleProductService.updateSaleProduct(id, newSaleProduct);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteSaleProduct(@PathVariable("id") int id) {
        saleProductService.deleteSaleProduct(id);
    }
}
