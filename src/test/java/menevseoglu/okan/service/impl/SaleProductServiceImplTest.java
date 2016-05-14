package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.SaleProduct;
import menevseoglu.okan.repository.SaleProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * This class has the unit tests for the sale-product service operations.
 */
public class SaleProductServiceImplTest {

    @Mock
    SaleProductRepository saleProductRepository;

    @Mock
    private ArrayList<SaleProduct> saleProductList;

    @Mock
    private SaleProduct saleProduct;

    @InjectMocks
    SaleProductServiceImpl saleProductService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * @verifies invoke findAll method of saleProduct repository
     * @see SaleProductServiceImpl#getSaleProducts()
     */
    @Test
    public void getSaleProducts_shouldInvokeFindAllMethodOfSaleProductRepository() throws Exception {
        saleProductService.getSaleProducts();
        verify(saleProductRepository, times(1)).findAll();
    }

    /**
     * @verifies return what saleProduct repository returns
     * @see SaleProductServiceImpl#getSaleProducts()
     */
    @Test
    public void getSaleProducts_shouldReturnWhatSaleProductRepositoryReturns() throws Exception {
        when(saleProductRepository.findAll()).thenReturn(saleProductList);
        assertEquals(saleProductService.getSaleProducts(), saleProductList);
    }

    /**
     * @verifies invoke findOne method of saleProduct repository with given id
     * @see SaleProductServiceImpl#getSaleProduct
     */
    @Test
    public void getSaleProduct_shouldInvokeFindOneMethodOfSaleProductRepositoryWithGivenId() throws Exception {
        saleProductService.getSaleProduct(anyInt());
        verify(saleProductRepository, times(1)).findOne(anyInt());
    }

    /**
     * @verifies return what saleProduct repository returns
     * @see SaleProductServiceImpl#getSaleProduct
     */
    @Test
    public void getSaleProduct_shouldReturnWhatSaleProductRepositoryReturns() throws Exception {
        when(saleProductRepository.findOne(anyInt())).thenReturn(saleProduct);
        assertEquals(saleProductService.getSaleProduct(1), saleProduct);
    }

    /**
     * @verifies invoke save method of saleProduct repository
     * @see SaleProductServiceImpl#saveSaleProduct(menevseoglu.okan.model.SaleProduct)
     */
    @Test
    public void saveSaleProduct_shouldInvokeSaveMethodOfSaleProductRepository() throws Exception {
        saleProductService.saveSaleProduct(saleProduct);
        verify(saleProductRepository, times(1)).save(saleProduct);
    }

    /**
     * @verifies invoke save method of saleProduct repository with given id and new saleProduct data
     * @see SaleProductServiceImpl#updateSaleProduct(int, menevseoglu.okan.model.SaleProduct)
     */
    @Test
    public void updateSaleProduct_shouldInvokeSaveMethodOfSaleProductRepositoryWithGivenIdAndNewSaleProductData() throws Exception {
        saleProductService.updateSaleProduct(anyInt(), saleProduct);
        verify(saleProductRepository, times(1)).findOne(anyInt());
        verify(saleProductRepository, times(1)).save(saleProductRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke save method of saleProduct repository even if at least one data is null
     * @see SaleProductServiceImpl#updateSaleProduct(int, menevseoglu.okan.model.SaleProduct)
     */
    @Test
    public void updateSaleProduct_shouldInvokeSaveMethodOfSaleProductRepositoryEvenIfAtLeastOneDataIsNull() throws Exception {
        saleProduct.setSaleAmount((short) 0);
        saleProductService.updateSaleProduct(anyInt(), saleProduct);
        verify(saleProductRepository, times(1)).findOne(anyInt());
        verify(saleProductRepository, times(1)).save(saleProductRepository.findOne(anyInt()));
    }

    /**
     * @verifies invoke delete method of saleProduct repository with given id
     * @see SaleProductServiceImpl#deleteSaleProduct
     */
    @Test
    public void deleteSaleProduct_shouldInvokeDeleteMethodOfSaleProductRepositoryWithGivenId() throws Exception {
        saleProductService.deleteSaleProduct(anyInt());
        verify(saleProductRepository, times(1)).delete(anyInt());
    }
}
