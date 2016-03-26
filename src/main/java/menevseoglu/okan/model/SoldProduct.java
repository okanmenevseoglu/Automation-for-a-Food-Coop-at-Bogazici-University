package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the sold_product table that stores the information of a product to be sold in a sale.
 */
@Entity
@Data
public class SoldProduct {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private short soldAmount;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Sale sale;
}