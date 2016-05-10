package menevseoglu.okan.controller;

import menevseoglu.okan.model.ProductCategory;
import menevseoglu.okan.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class that handles request and response methods of the product category operations.
 */
@RestController
@RequestMapping(value = "/productCategories")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Iterable<ProductCategory> getProductCategories() {
        return productCategoryService.getProductCategories();
    }

    @RequestMapping(value = "byId/{id}", method = RequestMethod.GET)
    public ProductCategory getProductCategory(@PathVariable("id") short id) {
        return productCategoryService.getProductCategory(id);
    }

    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public ProductCategory getProductCategory(@PathVariable("name") String name) {
        return productCategoryService.getProductCategory(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addProductCategory(@Valid @RequestBody ProductCategory productCategory) {
        productCategoryService.saveProductCategory(productCategory);
    }

    @RequestMapping(value = "/update/byId/{id}", method = RequestMethod.PUT)
    public void updateProductCategory(@PathVariable("id") short id, @RequestBody ProductCategory newProductCategory) {
        productCategoryService.updateProductCategory(id, newProductCategory);
    }

    @RequestMapping(value = "/update/byName/{name}", method = RequestMethod.PUT)
    public void updateProductCategory(@PathVariable("name") String name, @RequestBody ProductCategory newProductCategory) {
        productCategoryService.updateProductCategory(name, newProductCategory);
    }

    @RequestMapping(value = "/delete/byId/{id}", method = RequestMethod.DELETE)
    public void deleteProductCategory(@PathVariable("id") short id) {
        productCategoryService.deleteProductCategory(id);
    }

    @RequestMapping(value = "/delete/byName/{name}", method = RequestMethod.DELETE)
    public void deleteProductCategory(@PathVariable("name") String name) {
        productCategoryService.deleteProductCategory(name);
    }
}
