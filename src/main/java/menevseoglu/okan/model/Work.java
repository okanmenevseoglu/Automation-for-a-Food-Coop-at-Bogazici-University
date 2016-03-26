package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 * Entity representation of the work table that stores work information.
 */
@Entity
@Data
public class Work {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false)
    private WorkType workType;

    @ManyToOne(optional = false)
    private Member member;
}