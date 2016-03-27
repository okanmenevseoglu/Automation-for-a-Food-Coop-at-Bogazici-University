package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Entity representation of the bulletin table that stores information about bulletins of the cooperative.
 */
@Entity
@Data
public class Bulletin {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, columnDefinition = "VARCHAR(2083)")
    private String bulletinURL;
}
