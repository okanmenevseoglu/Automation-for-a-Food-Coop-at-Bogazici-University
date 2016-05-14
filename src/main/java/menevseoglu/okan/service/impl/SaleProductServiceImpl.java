package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.SaleProduct;
import menevseoglu.okan.repository.SaleProductRepository;
import menevseoglu.okan.service.SaleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the sale-product operations.
 */
@Service
@Transactional
public class SaleProductServiceImpl implements SaleProductService {

    @Autowired
    SaleProductRepository saleProductRepository;

    /**
     * @return Iterable SaleProduct object
     * @should invoke findAll method of saleProduct repository
     * @should return what saleProduct repository returns
     */
    @Override
    public Iterable<SaleProduct> getSaleProducts() {
        return saleProductRepository.findAll();
    }

    /**
     * @param id of the saleProduct
     * @return SaleProduct object with the given id
     * @should invoke findOne method of saleProduct repository with given id
     * @should return what saleProduct repository returns
     */
    @Override
    public SaleProduct getSaleProduct(int id) {
        return saleProductRepository.findOne(id);
    }

    /**
     * @param saleProduct to be saved
     * @should invoke save method of saleProduct repository
     */
    @Override
    public void saveSaleProduct(SaleProduct saleProduct) {
        saleProductRepository.save(saleProduct);
    }

    /**
     * @param id             of the saleProduct that will be updated
     * @param newSaleProduct to represent new values
     * @should invoke save method of saleProduct repository with given id and new saleProduct data
     * @should invoke save method of saleProduct repository even if saleProduct data is null
     */
    @Override
    public void updateSaleProduct(int id, SaleProduct newSaleProduct) {
        SaleProduct oldSaleProduct = saleProductRepository.findOne(id);
        if (newSaleProduct.getSaleAmount() != 0)
            oldSaleProduct.setSaleAmount(newSaleProduct.getSaleAmount());
        saleProductRepository.save(oldSaleProduct);
    }

    /**
     * @param id of the saleProduct that will be deleted
     * @should invoke delete method of saleProduct repository with given id
     */
    @Override
    public void deleteSaleProduct(int id) {
        saleProductRepository.delete(id);
    }
}
