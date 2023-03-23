package board.game.score.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import board.game.score.back.entity.Game;

@Repository
public interface GameRepository 
	extends JpaRepository<Game, String> {
}
