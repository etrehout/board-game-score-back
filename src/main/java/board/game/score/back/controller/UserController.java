package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
