package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import board.game.score.back.dto.UserDto;
import board.game.score.back.entity.User;
import board.game.score.back.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Resource(name = "userService")
    private UserService userService;
	
    @GetMapping
    public List <User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
    
    @PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@Valid @RequestBody UserDto user, BindingResult bindingResult) {
		User newUser = new User();
		newUser.setName(user.getName());
		newUser.setSurname(user.getSurname());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setRole(user.getRole());
		return userService.registerUser(newUser);
	}
}
