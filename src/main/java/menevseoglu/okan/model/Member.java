package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


/**
 * Entity representation of the member table that stores information about the members of the cooperative.
 */
@Data
@Entity
public class Member implements UserDetails {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Column(nullable = false)
    private String firstName;

    @NotBlank
    @Column(nullable = false)
    private String lastName;

    @Email(regexp = "^[a-z0-9_\\.-]{1,}@(boun).(edu).(tr)$")
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private char gender;

    @NotBlank
    @Column(nullable = false)
    private String idNumber;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @Column(columnDefinition = "VARCHAR(2083)")
    private String photoUrl;

    @NotBlank
    @Column(nullable = false)
    private String city;

    private String postalCode;

    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")
    @Column(nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "TEXT")
    private String aboutMember;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp registerTime;

    @OneToOne
    private Photo photo;

    @ManyToOne(optional = false)
    private MemberType memberType;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<StarRating> starRating;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Sale> saleList;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Comment> commentList;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Post> postList;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Work> workList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(getMemberType().getName()));
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
