package board.game.score.back.service;

import board.game.score.back.entity.User;
import board.game.score.back.handler.BgsException;
import board.game.score.back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User registerUser(@Valid User user) throws BgsException {
        Optional<User> userEmail = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userEmail.isPresent()) throw new BgsException("User already exists!");
        else userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws BgsException {
        if (email.trim().isEmpty()) throw new BgsException("Email cannot be empty.");
        User user = userRepository.findByEmail(email);
        if (user == null) throw new BgsException("The user " + email + " does not exist.");

        List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);
        org.springframework.security.core.userdetails.User springUser =
                new org.springframework.security.core.userdetails.User
                        (user.getEmail(), user.getPassword(), grantedAuthorities);
        return springUser;
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        return authorities;
    }

}
