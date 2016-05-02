package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the post_type table that stores the type of a post.
 */
@Data
@Entity
public class PostType {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "postType")
    private List<Post> postList;
}
