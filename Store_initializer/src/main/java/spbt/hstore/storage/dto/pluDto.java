package spbt.hstore.storage.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.PLU;

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
    }
}
