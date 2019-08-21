package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StoreDto {
    private Long id;
    private String  name;
    private String address;
    private String arrivalDay; //тут нужен лист
    private String workTime;
    private Integer count; //count items from this store

}
