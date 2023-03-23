package board.game.score.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.game.score.back.entity.BoardGame;
import board.game.score.back.repository.BoardGameRepository;

@Service
public class BoardGameService {
	
	@Autowired
    private BoardGameRepository boardGameRepository;

	public List<BoardGame> getAllBoardGames() {
		return boardGameRepository.findAll();
	}

}
