package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity representation of the post table that stores the different types of pages depending on its type.
 * Ex.: events, news etc.
 */
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private Timestamp postTime;

    private Date dateOfOccurence;

    @ManyToOne(optional = false)
    private Member member;

    @ManyToOne(optional = false)
    private PostType postType;

    @OneToMany(mappedBy = "post")
    private List<Photo> photoList;
}
