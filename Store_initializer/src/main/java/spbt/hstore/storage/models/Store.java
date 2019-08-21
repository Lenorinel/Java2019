package spbt.hstore.storage.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "stores_tab")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @Enumerated(value = EnumType.STRING)
    private List<WeekDays> arrivalDays;

    private String workTime;

    //количество шмота купленного в данном магазине
    private Integer count;

    //private byte rating;

    @OneToMany(mappedBy = "store")
    private List<PLU> pluListFromStore;

}
