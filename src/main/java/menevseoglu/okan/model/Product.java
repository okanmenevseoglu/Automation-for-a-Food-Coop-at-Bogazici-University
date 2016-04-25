package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the product table that stores the products of the cooperative.
 */
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private int unit;

    @Column(nullable = false)
    private float starRate;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Producer producer;

    @JsonIgnore
    @ManyToOne(optional = false)
    private UnitType unitType;

    @JsonIgnore
    @ManyToOne(optional = false)
    private PackageType packageType;

    @JsonIgnore
    @ManyToOne(optional = false)
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product")
    private List<Photo> photoList;

    @OneToMany(mappedBy = "product")
    private List<Comment> commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SoldProduct> soldProductList;

    @OneToMany(mappedBy = "product")
    private List<StarRating> starRatingList;
}
