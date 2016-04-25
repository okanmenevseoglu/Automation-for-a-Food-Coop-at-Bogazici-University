package menevseoglu.okan.model;

import lombok.Data;

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

    @Column(nullable = false, columnDefinition = "VARCHAR(2083)")
    private String photoURL;

    @OneToOne
    private Member member;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Post post;
}
