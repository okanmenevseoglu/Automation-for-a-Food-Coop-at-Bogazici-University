package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the post_type table that stores the type of the post.
 */
@Entity
@Data
public class PostType {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "postType")
    private List<Post> postList;
}
