package spbt.hstore.storage.utils;

import org.springframework.stereotype.Component;
import spbt.hstore.storage.dto.UserDto;
import spbt.hstore.storage.models.User;
import spbt.hstore.storage.security.details.UserDetailsImpl;

import static spbt.hstore.storage.dto.UserDto.from;


@Component
public class UserAuthenticationUtil {
    public UserDto getUserByUserDetails(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return from(user);
    }
}
