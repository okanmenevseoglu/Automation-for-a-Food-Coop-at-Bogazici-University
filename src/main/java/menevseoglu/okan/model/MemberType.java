package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the member_type table that stores the type of the member.
 */
@Entity
@Data
public class MemberType {

    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "memberType")
    private List<Member> memberList;
}