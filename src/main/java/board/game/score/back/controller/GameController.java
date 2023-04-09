package board.game.score.back.controller;

import board.game.score.back.entity.Game;
import board.game.score.back.service.GameService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

	@Resource(name = "gameService")
    private GameService gameService;
	
    @GetMapping
    public List <Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable("id") Long id) {
        return gameService.getGameById(id);
    }
}
