package menevseoglu.okan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the payment_type table that stores the type of the payment that is used in a sale.
 */
@Entity
@Data
public class PaymentType {
    @Id
    @GeneratedValue
    private short id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "paymentType")
    private List<Sale> saleList;
}
