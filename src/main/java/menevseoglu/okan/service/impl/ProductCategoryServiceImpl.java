package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.ProductCategory;
import menevseoglu.okan.repository.ProductCategoryRepository;
import menevseoglu.okan.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the product category operations.
 */
@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    /**
     * @return Iterable ProductCategory object
     * @should invoke findAll method of product category repository
     * @should return what product category repository returns
     */
    @Override
    public Iterable<ProductCategory> getProductCategories() {
        return productCategoryRepository.findAll();
    }

    /**
     * @param id of the product category
     * @return ProductCategory object with the given id
     * @should invoke findOne method of product category repository with given id
     * @should return what product category repository returns
     */
    @Override
    public ProductCategory getProductCategory(short id) {
        return productCategoryRepository.findOne(id);
    }

    /**
     * @param productCategoryName for the name of the product category
     * @return ProductCategory object with the given name
     * @should invoke findOne method of product category repository with given name
     */
    @Override
    public ProductCategory getProductCategory(String productCategoryName) {
        return productCategoryRepository.findByName(productCategoryName);
    }

    /**
     * @param productCategory to be saved
     * @should invoke save method of product category repository
     */
    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    /**
     * @param id                 of the product category that will be updated
     * @param newProductCategory to represent new values
     * @should invoke save method of product category repository with given id and new product category data
     * @should invoke save method of product category repository if data is not null
     */
    @Override
    public void updateProductCategory(short id, ProductCategory newProductCategory) {
        ProductCategory oldProductCategory = productCategoryRepository.findOne(id);
        if (newProductCategory.getName() != null)
            oldProductCategory.setName(newProductCategory.getName());
        productCategoryRepository.save(oldProductCategory);
    }

    /**
     * @param oldProductCategoryName of the product category that will be updated
     * @param newProductCategory     to represent new values
     * @should invoke save method of product category repository with given name and new product category data
     */
    @Override
    public void updateProductCategory(String oldProductCategoryName, ProductCategory newProductCategory) {
        ProductCategory oldProductCategory = productCategoryRepository.findByName(oldProductCategoryName);
        if (newProductCategory.getName() != null)
            oldProductCategory.setName(newProductCategory.getName());
        productCategoryRepository.save(oldProductCategory);
    }

    /**
     * @param id of the product category that will be deleted
     * @should invoke delete method of product category repository with given id
     */
    @Override
    public void deleteProductCategory(short id) {
        productCategoryRepository.delete(id);
    }

    /**
     * @param productCategoryName of the product category that will be deleted
     * @should invoke delete method of product category repository with given name
     */
    @Override
    public void deleteProductCategory(String productCategoryName) {
        productCategoryRepository.deleteByName(productCategoryName);
    }
}
