package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spbt.hstore.storage.Forms.SignInForm;
import spbt.hstore.storage.Repository.CookieValuesRepository;
import spbt.hstore.storage.Repository.UsersRepository;
import spbt.hstore.storage.dto.UserDto;
import spbt.hstore.storage.models.CookieValue;
import spbt.hstore.storage.models.User;
import spbt.hstore.storage.models.enums.UserState;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static spbt.hstore.storage.dto.UserDto.from;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public Optional<String> signIn(SignInForm form) {

        Optional<User> userCandidate = usersRepository.findUserByLogin(form.getLogin());

        if (userCandidate.isPresent()){
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())){
                CookieValue cookieValue = CookieValue.builder()
                        .value(UUID.randomUUID().toString())
                        .user(user)
                        .build();
                cookieValuesRepository.save(cookieValue);
                return Optional.of(cookieValue.getValue());
            }
        }

        return Optional.empty();
    }


    @Override
    public Optional<UserDto> getUserByCookie(String cookie) {

        Optional<CookieValue> cookieValueCandidate = cookieValuesRepository.findByValue(cookie);
        if (cookieValueCandidate.isPresent()){
            CookieValue cookieValue = cookieValueCandidate.get();
            User user = cookieValue.getUser();
            if (user.getState().equals(UserState.CONFIRMED)){
                return Optional.of(from(user));
            }
            else return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = usersRepository.findAll();
       return from(users);
    }
}
