package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the product table that stores the products of the cooperative.
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @NotBlank
    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private int unit;

    @Column(nullable = false)
    private float starRate;

    @ManyToOne(optional = false)
    private Producer producer;

    @ManyToOne(optional = false)
    private UnitType unitType;

    @ManyToOne(optional = false)
    private PackageType packageType;

    @ManyToOne(optional = false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private List<Photo> photoList;

    @OneToMany(mappedBy = "product")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "product")
    private List<StarRating> starRatingList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SoldProduct> soldProductList;
}
