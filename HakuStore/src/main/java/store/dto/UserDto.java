package store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import store.models.User;
import store.models.UserRoles;

import javax.persistence.*;

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
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .build();
    }
}
