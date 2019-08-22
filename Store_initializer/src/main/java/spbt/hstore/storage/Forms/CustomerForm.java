package spbt.hstore.storage.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerForm {
    private String name;
    private String instagram;
    private String address;
    private String comment;
}
