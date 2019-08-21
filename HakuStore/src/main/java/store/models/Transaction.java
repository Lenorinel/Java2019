package store.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "transaction_tab")

public class Transaction {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date")
    private Date date;

    @Column(name = "customer_address")
    private String customerAddress;

    private String comments;

    private Boolean delivery;

    private Double transactionPrice;


    @OneToMany (mappedBy = "transaction")
    private List<PLU> plusInTransaction;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
