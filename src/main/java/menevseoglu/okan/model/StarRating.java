package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Entity representation of the star_rating table that stores the information of a star rating of a related product.
 */
@Data
@Entity
public class StarRating {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private float starRate;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Member member;
}
