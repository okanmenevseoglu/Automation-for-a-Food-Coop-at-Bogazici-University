package menevseoglu.okan.controller;

import menevseoglu.okan.model.Product;
import menevseoglu.okan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by okanm on 27.03.2016.
 */
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public Iterable<Product> showAllProducts() {
        return productService.findAllProducts();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "YEAHH";
    }
}
