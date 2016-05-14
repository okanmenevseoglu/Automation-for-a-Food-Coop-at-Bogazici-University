package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity representation of the post table that stores information of the different types of posts.
 * Ex.: events, news, writings, etc.
 */
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "VARCHAR(2048)")
    private String title;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp dateOfCreation;

    private Date dateOfOccurrence;

    @ManyToOne(optional = false)
    private Member member;

    @ManyToOne(optional = false)
    private PostType postType;

    @OneToMany(mappedBy = "post")
    private List<Photo> photoList;
}
