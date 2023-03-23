package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.game.score.back.entity.Score;
import board.game.score.back.service.ScoreService;

@RestController
@RequestMapping("/scores")
public class ScoreController {

	@Resource(name = "scoreService")
    private ScoreService scoreService;
	
    @GetMapping
    public List <Score> getAllScores() {
        return scoreService.getAllScores();
    }
}
