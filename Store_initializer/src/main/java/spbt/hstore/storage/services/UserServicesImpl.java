package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spbt.hstore.storage.Repository.UsersRepository;
import spbt.hstore.storage.dto.UserDto;
import spbt.hstore.storage.models.User;

import java.util.List;

import static spbt.hstore.storage.dto.UserDto.from;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = usersRepository.findAll();
       return from(users);
    }
}
