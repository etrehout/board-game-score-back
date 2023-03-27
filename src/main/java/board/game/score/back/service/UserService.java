package board.game.score.back.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import board.game.score.back.entity.User;
import board.game.score.back.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User registerUser(@Valid User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if (email.trim().isEmpty()) throw new UsernameNotFoundException("Email cannot be empty.");

		User user = userRepository.findByEmail(email);
		if (user == null) throw new UsernameNotFoundException("The user " + email + " does not exist.");
		
		List<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(user);
		org.springframework.security.core.userdetails.User springUser = 
				new org.springframework.security.core.userdetails
				.User(user.getEmail(), user.getPassword(), grantedAuthorities);
		return springUser;
	}

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));	
        return authorities;
    }
	
}
