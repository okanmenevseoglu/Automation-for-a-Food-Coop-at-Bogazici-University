package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Product;
import menevseoglu.okan.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the product service operations.
 */
public class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    private ArrayList<Product> productList;

    @Mock
    private Product product;

    @InjectMocks
    ProductServiceImpl productService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of product repository
     * @see ProductServiceImpl#getProducts()
     */
    @Test
    public void getProducts_shouldInvokeFindAllMethodOfProductRepository() throws Exception {
        productService.getProducts();
        verify(productRepository, times(1)).findAll();
    }

    /**
     * @verifies return what product repository returns
     * @see ProductServiceImpl#getProducts()
     */
    @Test
    public void getProducts_shouldReturnWhatProductRepositoryReturns() throws Exception {
        when(productRepository.findAll()).thenReturn(productList);
        assertEquals(productService.getProducts(), productList);
    }

    /**
     * @verifies invoke findOne method of product repository with given id
     * @see ProductServiceImpl#getProduct(short)
     */
    @Test
    public void getProduct_shouldInvokeFindOneMethodOfProductRepositoryWithGivenId() throws Exception {
        productService.getProduct(anyShort());
        verify(productRepository, times(1)).findOne(anyShort());
    }

    /**
     * @verifies return what product repository returns
     * @see ProductServiceImpl#getProduct(short)
     */
    @Test
    public void getProduct_shouldReturnWhatProductRepositoryReturns() throws Exception {
        when(productRepository.findOne(anyShort())).thenReturn(product);
        assertEquals(productService.getProduct((short) 1), product);
    }

    /**
     * @verifies invoke save method of product repository
     * @see ProductServiceImpl#saveProduct(menevseoglu.okan.model.Product)
     */
    @Test
    public void saveProduct_shouldInvokeSaveMethodOfProductRepository() throws Exception {
        productService.saveProduct(product);
        verify(productRepository, times(1)).save(product);
    }

    /**
     * @verifies invoke save method of product repository with given id and new product data
     * @see ProductServiceImpl#updateProduct(short, menevseoglu.okan.model.Product)
     */
    @Test
    public void updateProduct_shouldInvokeSaveMethodOfProductRepositoryWithGivenIdAndNewProductData() throws Exception {
        productService.updateProduct(anyShort(), product);
        verify(productRepository, times(1)).findOne(anyShort());
        verify(productRepository, times(1)).save(productRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke save method of product repository even if at least one data is null
     * @see ProductServiceImpl#updateProduct(short, menevseoglu.okan.model.Product)
     */
    @Test
    public void updateProduct_shouldInvokeSaveMethodOfProductRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        product.setName(null);
        productService.updateProduct(anyShort(), product);
        product.setDescription(null);
        productService.updateProduct(anyShort(), product);
        product.setPrice(0);
        productService.updateProduct(anyShort(), product);
        product.setStock(0);
        productService.updateProduct(anyShort(), product);
        product.setUnit(0);
        productService.updateProduct(anyShort(), product);
        product.setStarRate(0);
        productService.updateProduct(anyShort(), product);
        product.setUnitType(null);
        productService.updateProduct(anyShort(), product);
        product.setPackageType(null);
        productService.updateProduct(anyShort(), product);
        verify(productRepository, times(8)).findOne(anyShort());
        verify(productRepository, times(8)).save(productRepository.findOne(anyShort()));
    }

    /**
     * @verifies invoke delete method of product repository with given id
     * @see ProductServiceImpl#deleteProduct(short)
     */
    @Test
    public void deleteProduct_shouldInvokeDeleteMethodOfProductRepositoryWithGivenId() throws Exception {
        productService.deleteProduct(anyShort());
        verify(productRepository, times(1)).delete(anyShort());
    }
}
