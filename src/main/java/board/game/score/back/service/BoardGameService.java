package board.game.score.back.service;

import board.game.score.back.entity.BoardGame;
import board.game.score.back.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardGameService {

    @Autowired
    private BoardGameRepository boardGameRepository;

    public List<BoardGame> getAllBoardGames() {
        return boardGameRepository.findAll();
    }

    public BoardGame getBoardGameById(Long id) {
        return boardGameRepository.findById(id);
    }

}
