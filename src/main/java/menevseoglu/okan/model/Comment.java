package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity representation of the comment table that stores the comments information of a product.
 */
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Email
    private String email;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp commentTime;

    @ManyToOne
    private Member member;

    @JsonIgnore
    @ManyToOne(optional = false)
    private Product product;

    @JsonIgnore
    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> childrenComment;
}
