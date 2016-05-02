package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Entity representation of the bulletin table that stores information about the bulletins of the cooperative.
 */
@Data
@Entity
public class Bulletin {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Date date;

    @NotBlank
    @Column(columnDefinition = "VARCHAR(2083)", nullable = false)
    private String url;
}
