package menevseoglu.okan.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Entity representation of the sale table that stores the sale information.
 */
@Entity
@Data
public class Sale {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int totalPrice;

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp saleTime;

    private String idNumber;

    private String fullName;

    private String address;

    private String city;

    private String postalCode;

    private String phoneNumber;

    @ManyToOne(optional = false)
    private PaymentType paymentType;

    @ManyToOne
    private Member member;

    @OneToMany(mappedBy = "sale")
    private List<SoldProduct> soldProductList;
}