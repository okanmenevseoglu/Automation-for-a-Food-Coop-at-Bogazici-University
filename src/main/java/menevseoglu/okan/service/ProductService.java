package menevseoglu.okan.service;

import menevseoglu.okan.model.Product;

/**
 * This class is the abstract representation of the service layer for the product operations.
 */
public interface ProductService {

    Iterable<Product> getProducts();

    Product getProduct(short id);

    Product getProduct(String productName);

    void saveProduct(Product product);

    void updateProduct(short id, Product newProduct);

    void updateProduct(String oldProductName, Product newProduct);

    void deleteProduct(short id);

    void deleteProduct(String productName);
}
