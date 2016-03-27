package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the product_category table that stores the category information of the products.
 */
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "parentProductCategory")
    private List<ProductCategory> childrenCategoryList;

    @ManyToOne
    private ProductCategory parentProductCategory;
}
