package spbt.hstore.storage.security.details;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spbt.hstore.storage.Repository.UsersRepository;
import spbt.hstore.storage.models.User;

import java.util.Optional;


@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<User> userCandidate = usersRepository.findUserByLogin(login);

        if (userCandidate.isPresent()) {

            User user = userCandidate.get();

            return new UserDetailsImpl(user);
        }

        throw new UsernameNotFoundException("User with login " + login
               + " not found");
    }
}
