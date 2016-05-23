package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Sale;
import menevseoglu.okan.repository.SaleRepository;
import menevseoglu.okan.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is the business layer of the sale operations.
 */
@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;

    /**
     * @return Iterable Sale object
     * @should invoke findAll method of sale repository
     * @should return what sale repository returns
     */
    @Override
    public Iterable<Sale> getSales() {
        return saleRepository.findAll();
    }

    /**
     * @param id of the sale
     * @return Sale object with the given id
     * @should invoke findOne method of sale repository with given id
     * @should return what sale repository returns
     */
    @Override
    public Sale getSale(int id) {
        return saleRepository.findOne(id);
    }

    /**
     * @param sale to be saved
     * @should invoke save method of sale repository
     */
    @Override
    public void saveSale(Sale sale) {
        saleRepository.save(sale);
    }

    /**
     * @param id of the sale that will be deleted
     * @should invoke delete method of sale repository with given id
     */
    @Override
    public void deleteSale(int id) {
        saleRepository.delete(id);
    }
}
