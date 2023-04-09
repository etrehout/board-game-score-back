package board.game.score.back.repository;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import board.game.score.back.entity.BoardGame;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, String> {
	BoardGame findById(Long id);

}
