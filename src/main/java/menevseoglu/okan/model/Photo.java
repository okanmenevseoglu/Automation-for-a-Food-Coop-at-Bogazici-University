package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Entity representation of the photo table that stores the photos of the related cooperative component.
 */
@Data
@Entity
public class Photo {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "VARCHAR(2083)")
    private String photoURL;

    @JsonIgnore
    @OneToOne
    private Member member;

    @JsonIgnore
    @ManyToOne
    private Product product;

    @JsonIgnore
    @ManyToOne
    private Producer producer;

    @JsonIgnore
    @ManyToOne
    private Post post;
}
