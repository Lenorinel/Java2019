package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerDto {
    private Long id;
    private String name;
    private String address;
    private String comment;
    private Integer count;
    private String instagram;

}
