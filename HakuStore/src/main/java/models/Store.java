package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "stores_tab")
public class Store {
    private Long id;
    private String name;
    private String address;
    private Date arrivalDate;
    private String workTime;
    //private byte rating;
    @OneToMany(mappedBy = "store")
    private List<PLU> pluListFromStore;

}
