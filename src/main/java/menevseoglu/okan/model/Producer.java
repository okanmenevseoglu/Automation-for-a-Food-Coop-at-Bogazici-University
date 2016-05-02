package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the producer table that stores the information of a producer.
 */
@Data
@Entity
public class Producer {

    @Id
    @GeneratedValue
    private short id;

    private String firstName;

    private String lastName;

    private String companyName;

    @NotBlank
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private String phone;

    @Email
    private String email;

    @Column(columnDefinition = "VARCHAR(2083)")
    private String address;

    @NotBlank
    @Column(nullable = false)
    private String city;

    @Column(columnDefinition = "FLOAT(10,6)")
    private float latitude;

    @Column(columnDefinition = "FLOAT(10,6)")
    private float longitude;

    @JsonIgnore
    @OneToMany(mappedBy = "producer")
    private List<Product> productList;

    @JsonIgnore
    @OneToMany(mappedBy = "producer")
    private List<Photo> photoList;
}
