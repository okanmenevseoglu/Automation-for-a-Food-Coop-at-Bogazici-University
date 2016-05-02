package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.ProductCategory;
import menevseoglu.okan.repository.ProductCategoryRepository;
import menevseoglu.okan.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by okanm on 29.04.2016.
 */
@Service
public class ProductCategoryImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public void addNewProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }
}
