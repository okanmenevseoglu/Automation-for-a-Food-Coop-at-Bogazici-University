package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the star_rating table that stores the information of a star rating of a related product.
 */
@Entity
@Data
public class StarRating {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private float starRate;

    @OneToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Member member;
}