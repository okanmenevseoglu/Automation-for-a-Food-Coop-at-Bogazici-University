package menevseoglu.okan.service;

import menevseoglu.okan.model.SaleProduct;

/**
 * This class is the abstract representation of the service layer for the sale-product operations.
 */
public interface SaleProductService {

    Iterable<SaleProduct> getSaleProducts();

    SaleProduct getSaleProduct(int id);

    void saveSaleProduct(SaleProduct saleProduct);

    void updateSaleProduct(int id, SaleProduct newSaleProduct);

    void deleteSaleProduct(int id);
}
