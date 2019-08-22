package spbt.hstore.storage.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PLUForm {
    private String name;
    private String type;
    private String size;
    private Double firstprice;
    private Double sellprice;
    private String storeName;
}
