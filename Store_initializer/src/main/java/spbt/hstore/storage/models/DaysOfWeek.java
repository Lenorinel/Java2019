package spbt.hstore.storage.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "arrival_days" )
public class DaysOfWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "arrival_day")
    private String arrivalDay;

    @ManyToOne
    @JoinColumn(name ="store_id")
    private Store store;

    public DaysOfWeek(String stringDay) {
        this.arrivalDay = stringDay;
    }
}
