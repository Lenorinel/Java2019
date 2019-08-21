package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {
    private Long id;
    private String login;
    private String name;
    private String role;


    public static UserDto from(User user){
        return UserDto.builder() // нет библиотеки?
    }

}
