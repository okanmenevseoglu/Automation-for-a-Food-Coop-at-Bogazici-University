package menevseoglu.okan.service.impl;

import menevseoglu.okan.model.Product;
import menevseoglu.okan.repository.ProductRepository;
import menevseoglu.okan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by okanm on 27.03.2016.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
