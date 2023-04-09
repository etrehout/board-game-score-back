package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.web.bind.annotation.*;

import board.game.score.back.entity.BoardGame;
import board.game.score.back.service.BoardGameService;

@RestController
@CrossOrigin
@RequestMapping("/boardgames")
public class BoardGameController {

	@Resource(name = "boardGameService")
    private BoardGameService boardGameService;
	
    @GetMapping
    public List <BoardGame> getAllBoardGames() {
        return boardGameService.getAllBoardGames();
    }

    @GetMapping("/{id}")
    public BoardGame getBoardGameById(@PathVariable("id") Long id) {
        return boardGameService.getBoardGameById(id);
    }
}
