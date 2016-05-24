package menevseoglu.okan.controller;

import menevseoglu.okan.model.Product;
import menevseoglu.okan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the product operations.
 */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") short id) {
        return productService.getProduct(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STOCKER')")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProduct(@Valid @RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STOCKER')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable("id") short id, @RequestBody Product newProduct) {
        productService.updateProduct(id, newProduct);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'STOCKER')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") short id) {
        productService.deleteProduct(id);
    }
}
