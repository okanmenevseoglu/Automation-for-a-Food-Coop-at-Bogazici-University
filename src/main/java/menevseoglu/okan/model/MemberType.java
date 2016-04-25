package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the member_type table that stores the types of the members.
 */
@Entity
@Data
public class MemberType {

    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "memberType")
    private List<Member> memberList;
}
