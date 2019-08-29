package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.Customer;
import spbt.hstore.storage.models.PLU;
import spbt.hstore.storage.models.Transaction;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<PLU> plu;
    private Customer customer;

    public static TransactionDto from(Transaction transaction){
        return TransactionDto.builder()
                .id(transaction.getId())
                .transactionDate((Date) transaction.getDate())
                .customerAddress(transaction.getCustomerAddress())
                .comment(transaction.getComments())
                .delivery(transaction.getDelivery())
                .transactionPrice(transaction.getTransactionPrice())
                .plu(transaction.getPlusInTransaction())
                .customer(transaction.getCustomer())
                .build();
    }

    public static List<TransactionDto> from(List<Transaction> transactions){
        return transactions.stream()
                .map(TransactionDto::from)
                .collect(Collectors.toList());
    }
}
