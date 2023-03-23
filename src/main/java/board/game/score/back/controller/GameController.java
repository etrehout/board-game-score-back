package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.game.score.back.entity.Game;
import board.game.score.back.service.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

	@Resource(name = "gameService")
    private GameService gameService;
	
    @GetMapping
    public List <Game> getAllGames() {
        return gameService.getAllGames();
    }
}
