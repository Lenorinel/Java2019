package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TransactionDto {
    private Long id;
    private Date transactionDate;
    private String customerAddress;
    private String comment;
    private Boolean delivery;
    private Double transactionPrice;
    //private String pluName; корректно ли такое использование товара?? DTOUsera
    //private String customer; //-~- Dto Кастомера (нужно чтобы из списка транзакций по выбору пользака открыть его карточку)
}
