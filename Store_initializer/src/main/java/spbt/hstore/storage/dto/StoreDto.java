package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.Store;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StoreDto {
    private Long id;
    private String  name;
    private String address;
   // private String arrivalDay; //тут нужен лист
    private String workTime;
    private Integer count; //count items from this store

    private static StoreDto from(Store store){
        return StoreDto.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
              //  .arrivalDays(store.getArrivalDays())
                .workTime(store.getWorkTime())
                .count(store.getCount())
                .build();
    }

    private static List<StoreDto> from(List<Store> stores){
        return stores.stream()
                .map(StoreDto::from)
                .collect(Collectors.toList());
    }
}
