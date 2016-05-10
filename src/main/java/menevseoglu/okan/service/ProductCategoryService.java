package menevseoglu.okan.service;

import menevseoglu.okan.model.ProductCategory;

/**
 * This class is the abstract representation of the service layer for the product category operations.
 */
public interface ProductCategoryService {

    Iterable<ProductCategory> getProductCategories();

    ProductCategory getProductCategory(short id);

    ProductCategory getProductCategory(String productCategoryName);

    void saveProductCategory(ProductCategory productCategory);

    void updateProductCategory(short id, ProductCategory newProductCategory);

    void updateProductCategory(String oldProductCategoryName, ProductCategory newProductCategory);

    void deleteProductCategory(short id);

    void deleteProductCategory(String productCategoryName);
}
