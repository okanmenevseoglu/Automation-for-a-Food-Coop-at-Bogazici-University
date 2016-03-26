package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the package_type table that stores the packaging type of the product.
 */
@Entity
@Data
public class PackageType {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "packageType")
    private List<Product> productList;
}