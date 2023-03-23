package board.game.score.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.game.score.back.entity.User;
import board.game.score.back.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
