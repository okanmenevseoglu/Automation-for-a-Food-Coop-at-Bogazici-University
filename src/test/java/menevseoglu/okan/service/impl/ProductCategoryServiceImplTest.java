package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.ProductCategory;
import menevseoglu.okan.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the product category service operations.
 */
public class ProductCategoryServiceImplTest {

    @Mock
    ProductCategoryRepository productCategoryRepository;

    @Mock
    private ArrayList<ProductCategory> productCategoryList;

    @Mock
    private ProductCategory productCategory;

    @InjectMocks
    ProductCategoryServiceImpl productCategoryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of product category repository
     * @see ProductCategoryServiceImpl#getProductCategories()
     */
    @Test
    public void getProductCategories_shouldInvokeFindAllMethodOfProductCategoryRepository() throws Exception {
        productCategoryService.getProductCategories();
        verify(productCategoryRepository, times(1)).findAll();
    }

    /**
     * @verifies return what product category repository returns
     * @see ProductCategoryServiceImpl#getProductCategories()
     */
    @Test
    public void getProductCategories_shouldReturnWhatProductCategoryRepositoryReturns() throws Exception {
        when(productCategoryRepository.findAll()).thenReturn(productCategoryList);
        assertEquals(productCategoryService.getProductCategories(), productCategoryList);
    }

    /**
     * @verifies invoke findOne method of product category repository with given id
     * @see ProductCategoryServiceImpl#getProductCategory(short)
     */
    @Test
    public void getProductCategory_shouldInvokeFindOneMethodOfProductCategoryRepositoryWithGivenId() throws Exception {
        productCategoryService.getProductCategory(anyShort());
        verify(productCategoryRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what product category repository returns
     * @see ProductCategoryServiceImpl#getProductCategory(short)
     */
    @Test
    public void getProductCategory_shouldReturnWhatProductCategoryRepositoryReturns() throws Exception {
        when(productCategoryRepository.findOne(anyShort())).thenReturn(productCategory);
        assertEquals(productCategoryService.getProductCategory((short) 1), productCategory);
    }

    /**
     * @verifies invoke findOne method of product category repository with given name
     * @see ProductCategoryServiceImpl#getProductCategory(String)
     */
    @Test
    public void getProductCategory_shouldInvokeFindOneMethodOfProductCategoryRepositoryWithGivenName() throws Exception {
        productCategoryService.getProductCategory(anyString());
        verify(productCategoryRepository, times(1)).findByName(anyString());
    }

    /**
     * @verifies invoke save method of product category repository
     * @see ProductCategoryServiceImpl#saveProductCategory(menevseoglu.okan.model.ProductCategory)
     */
    @Test
    public void saveProductCategory_shouldInvokeSaveMethodOfProductCategoryRepository() throws Exception {
        productCategoryService.saveProductCategory(productCategory);
        verify(productCategoryRepository, times(1)).save(productCategory);
    }

    /**
     * @verifies invoke save method of product category repository with given id and new product category data
     * @see ProductCategoryServiceImpl#updateProductCategory(short, menevseoglu.okan.model.ProductCategory)
     */
    @Test
    public void updateProductCategory_shouldInvokeSaveMethodOfProductCategoryRepositoryWithGivenIdAndNewProductCategoryData() throws Exception {
        productCategoryService.updateProductCategory(anyShort(), productCategory);
        verify(productCategoryRepository, times(1)).findOne(anyShort());
        verify(productCategoryRepository, times(1)).save(productCategoryRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of product category repository even if at least one data is null
     * @see ProductCategoryServiceImpl#updateProductCategory(short, menevseoglu.okan.model.ProductCategory)
     */
    @Test
    public void updateProductCategory_shouldInvokeSaveMethodOfProductCategoryRepositoryIfDataIsNotNull() throws Exception {
        productCategory.setName(anyString());
        productCategoryService.updateProductCategory(anyShort(), productCategory);
        verify(productCategoryRepository, times(1)).findOne(anyShort());
        verify(productCategoryRepository, times(1)).save(productCategoryRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of product category repository with given name and new product category data
     * @see ProductCategoryServiceImpl#updateProductCategory(String, menevseoglu.okan.model.ProductCategory)
     */
    @Test
    public void updateProductCategory_shouldInvokeSaveMethodOfProductCategoryRepositoryWithGivenNameAndNewProductCategoryData() throws Exception {
        productCategory.setName(anyString());
        productCategoryService.updateProductCategory(anyString(), productCategory);
        verify(productCategoryRepository, times(1)).findByName(anyString());
        verify(productCategoryRepository, times(1)).save(productCategoryRepository.findByName(anyString()));
    }

    /**
     * @verifies invoke delete method of product category repository with given id
     * @see ProductCategoryServiceImpl#deleteProductCategory(short)
     */
    @Test
    public void deleteProductCategory_shouldInvokeDeleteMethodOfProductCategoryRepositoryWithGivenId() throws Exception {
        productCategoryService.deleteProductCategory(anyShort());
        verify(productCategoryRepository, times(1)).delete(anyShort());
    }

    /**
     * @verifies invoke delete method of product category repository with given name
     * @see ProductCategoryServiceImpl#deleteProductCategory(String)
     */
    @Test
    public void deleteProductCategory_shouldInvokeDeleteMethodOfProductCategoryRepositoryWithGivenName() throws Exception {
        productCategoryService.deleteProductCategory(anyString());
        verify(productCategoryRepository, times(1)).deleteByName(anyString());
    }
}
