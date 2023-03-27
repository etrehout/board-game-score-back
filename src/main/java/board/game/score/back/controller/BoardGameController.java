package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
