package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity representation of the comment table that stores the comments information about the related products.
 */
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Email
    private String email;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp commentTime;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childrenComment;
}