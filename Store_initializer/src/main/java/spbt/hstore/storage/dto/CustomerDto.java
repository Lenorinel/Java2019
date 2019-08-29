package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.Customer;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CustomerDto from(Customer customer){
        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .address(customer.getAddress())
                .comment(customer.getComment())
                .count(customer.getCount())
                .instagram(customer.getInstagram())
                .build();
    }

    public static List<CustomerDto> from(List<Customer> customers) {
            return customers.stream()
            .map(CustomerDto::from)
            .collect(Collectors.toList());
    }
}
