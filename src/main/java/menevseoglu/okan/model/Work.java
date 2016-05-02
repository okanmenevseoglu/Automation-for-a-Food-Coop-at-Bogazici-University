package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Entity representation of the work table that stores volunteer work information.
 */
@Data
@Entity
public class Work {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp dateOfCreation;

    @Column(nullable = false)
    private Date dateOfWork;

    @ManyToOne(optional = false)
    private WorkType workType;

    @ManyToOne
    private Member member;
}
