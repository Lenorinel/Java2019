package spbt.hstore.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spbt.hstore.storage.models.User;

import java.util.List;
import java.util.stream.Collectors;

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
                .name(user.getName())
                .role(user.getRole().toString())
                .build();
    }

    public static List<UserDto> from(List<User> users){
        return users.stream()
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
