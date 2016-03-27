package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the producer table that stores the information of the producers.
 */
@Entity
@Data
public class Producer {
    @Id
    @GeneratedValue
    private short id;

    private String firstName;

    private String lastName;

    private String companyName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "VARCHAR(2083)")
    private String address;

    private String city;

    private String phone;

    @Email
    private String email;

    @Column(columnDefinition = "VARCHAR(2083)")
    private String photoURL;

    private float latitude;

    private float longitude;

    private String locationName;

    @OneToMany(mappedBy = "producer")
    private List<Product> productList;
}
