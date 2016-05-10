package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the product_category table that stores the category information of a product.
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "productCategory")
    private List<Product> productList;
}
