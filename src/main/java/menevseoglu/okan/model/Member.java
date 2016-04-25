package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * Entity representation of the member table that stores information about the members of the cooperative.
 */
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private char gender;

    @Column(nullable = false)
    private String idNumber;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    private String postalCode;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String aboutMember;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp registerTime;

    @OneToOne
    private Photo photo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private MemberType memberType;

    @OneToMany(mappedBy = "member")
    private List<Sale> saleList;

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "member")
    private List<Post> postList;

    @OneToMany(mappedBy = "member")
    private List<Work> workList;
}
