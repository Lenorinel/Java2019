package spbt.hstore.storage.services;

import spbt.hstore.storage.Forms.SignInForm;
import spbt.hstore.storage.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserServices {

    List<UserDto> getAllUsers();

}
