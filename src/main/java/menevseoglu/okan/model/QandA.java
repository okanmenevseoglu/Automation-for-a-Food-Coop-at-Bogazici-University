package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity representation of the qanda table that stores information about the frequently asked questions and their answers.
 */
@Entity
@Data
public class QandA {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false, columnDefinition = "VARCHAR(2000)")
    private String question;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String answer;
}