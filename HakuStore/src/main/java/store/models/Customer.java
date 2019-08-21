package store.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer_tab")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String name;
    private String address;
    private String comment;
    private Integer count;

    @Column(name = "instagram_login", length = 100, nullable = false)
    private String instagram;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> purchases;
}
