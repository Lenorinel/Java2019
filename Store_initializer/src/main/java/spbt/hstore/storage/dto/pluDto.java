package spbt.hstore.storage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.PLU;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class pluDto {
    private Long id;
    private String name;
    private String clothesType;
    private String size;
    private Double firstPrice;
    private Double sellPrice;
    private String addingDate; //String??
    private String status;
    private String store;

    public static pluDto from(PLU plu){
        return pluDto.builder()
                .id(plu.getId())
                .name(plu.getName())
                .clothesType(plu.getType().toString())
                .size(plu.getSize().toString())
                .firstPrice(plu.getFirstPrice())
                .sellPrice(plu.getSellPrice())
                .addingDate(plu.getAddingDate().toString())
                .status(plu.getStatus().toString())
                .store(plu.getStore().getName())
                .build();
    }

    public static List<pluDto> from(List<PLU> plu){
        return plu.stream()
                .map(pluDto::from)
                .collect(Collectors.toList());
    }
}
