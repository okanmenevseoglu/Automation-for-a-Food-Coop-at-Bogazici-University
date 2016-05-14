package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Product;
import menevseoglu.okan.repository.ProductRepository;
import menevseoglu.okan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the product category operations.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    /**
     * @return Iterable Product object
     * @should invoke findAll method of product category repository
     * @should return what product category repository returns
     */
    @Override
    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    /**
     * @param id of the product category
     * @return Product object with the given id
     * @should invoke findOne method of product category repository with given id
     * @should return what product category repository returns
     */
    @Override
    public Product getProduct(short id) {
        return productRepository.findOne(id);
    }

    /**
     * @param productName for the name of the product category
     * @return Product object with the given name
     * @should invoke findOne method of product category repository with given name
     */
    @Override
    public Product getProduct(String productName) {
        return productRepository.findByName(productName);
    }

    /**
     * @param product to be saved
     * @should invoke save method of product category repository
     */
    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    /**
     * @param id         of the product category that will be updated
     * @param newProduct to represent new values
     * @should invoke save method of product category repository with given id and new product category data
     * @should invoke save method of product category repository if data is not null
     */
    @Override
    public void updateProduct(short id, Product newProduct) {
        Product oldProduct = productRepository.findOne(id);
        if (newProduct.getName() != null)
            oldProduct.setName(newProduct.getName());
        if (newProduct.getDescription() != null)
            oldProduct.setDescription(newProduct.getDescription());
        if (newProduct.getPrice() > 0)
            oldProduct.setPrice(newProduct.getPrice());
        if (newProduct.getStock() > 0)
            oldProduct.setStock(newProduct.getStock());
        if (newProduct.getUnit() > 0)
            oldProduct.setUnit(newProduct.getUnit());
        if (newProduct.getUnitType() != null)
            oldProduct.setUnitType(newProduct.getUnitType());
        if (newProduct.getPackageType() != null)
            oldProduct.setPackageType(newProduct.getPackageType());
        productRepository.save(oldProduct);
    }

    /**
     * @param oldProductName of the product category that will be updated
     * @param newProduct     to represent new values
     * @should invoke save method of product category repository with given name and new product category data
     */
    @Override
    public void updateProduct(String oldProductName, Product newProduct) {
        Product oldProduct = productRepository.findByName(oldProductName);
        if (newProduct.getName() != null)
            oldProduct.setName(newProduct.getName());
        if (newProduct.getDescription() != null)
            oldProduct.setDescription(newProduct.getDescription());
        if (newProduct.getPrice() > 0)
            oldProduct.setPrice(newProduct.getPrice());
        if (newProduct.getStock() > 0)
            oldProduct.setStock(newProduct.getStock());
        if (newProduct.getUnit() > 0)
            oldProduct.setUnit(newProduct.getUnit());
        if (newProduct.getUnitType() != null)
            oldProduct.setUnitType(newProduct.getUnitType());
        if (newProduct.getPackageType() != null)
            oldProduct.setPackageType(newProduct.getPackageType());
        productRepository.save(oldProduct);
    }

    /**
     * @param id of the product category that will be deleted
     * @should invoke delete method of product category repository with given id
     */
    @Override
    public void deleteProduct(short id) {
        productRepository.delete(id);
    }

    /**
     * @param productName of the product category that will be deleted
     * @should invoke delete method of product category repository with given name
     */
    @Override
    public void deleteProduct(String productName) {
        productRepository.deleteByName(productName);
    }
}
