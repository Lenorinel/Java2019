package store.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreForm {
    private String name;
    private String address;
    private List<String> arrivalDays;
    private String workTime;
    private String comments;
}
