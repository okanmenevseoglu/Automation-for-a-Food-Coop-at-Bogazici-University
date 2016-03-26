package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the unit_type table that stores the unit type of the product.
 */
@Entity
@Data
public class UnitType {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "unitType")
    private List<Product> productList;
}