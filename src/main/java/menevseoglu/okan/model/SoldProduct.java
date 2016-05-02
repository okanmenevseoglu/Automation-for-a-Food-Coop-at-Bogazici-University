package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Entity representation of the sold_product table that stores the information of a product that is sold in a sale.
 */
@Data
@Entity
public class SoldProduct {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private short soldAmount;

    @ManyToOne(optional = false)
    private Product product;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Sale sale;
}
