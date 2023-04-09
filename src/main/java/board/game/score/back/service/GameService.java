package board.game.score.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.game.score.back.entity.Game;
import board.game.score.back.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
    private GameRepository gameRepository;

	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	public Game getGameById(Long id) {
		return gameRepository.findById(id);
	}
}
