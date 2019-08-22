package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import spbt.hstore.storage.Forms.SignInForm;
import spbt.hstore.storage.Repository.CookieValuesRepository;
import spbt.hstore.storage.Repository.UsersRepository;
import spbt.hstore.storage.dto.UserDto;
import spbt.hstore.storage.models.CookieValue;
import spbt.hstore.storage.models.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class UserServicesImpl implements UserServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CookieValuesRepository cookieValuesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional //что это и нужно ли при данной конфигурации?
    @Override
    public Optional<String> signIn(SignInForm form) {
        Optional<User> userCandidate = usersRepository.findUserByLogin(form.getLogin());

        if (userCandidate.isPresent()){
            User user = userCandidate.get();
            if (passwordEncoder.matches(form.getPassword(), user.getHashPassword())){
//                CookieValue cookieValue = CookieValue.builder()
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<UserDto> getUserByCookie(String cookie) {
        return Optional.empty();
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }
}
