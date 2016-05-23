package menevseoglu.okan.service;

import menevseoglu.okan.model.Sale;

/**
 * This class is the abstract representation of the service layer for the sale operations.
 */
public interface SaleService {

    Iterable<Sale> getSales();

    Sale getSale(int id);

    void saveSale(Sale sale);

    void deleteSale(int id);
}
