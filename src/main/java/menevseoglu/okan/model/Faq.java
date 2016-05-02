package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity representation of the faq table that stores information about the frequently asked questions and their answers.
 */
@Data
@Entity
public class Faq {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String question;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String answer;
}
