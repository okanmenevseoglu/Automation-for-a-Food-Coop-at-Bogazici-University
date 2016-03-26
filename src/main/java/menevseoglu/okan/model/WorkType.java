package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the work_type table that stores the type of the volunteer work.
 */
@Entity
@Data
public class WorkType {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "workType")
    private List<Work> workList;
}