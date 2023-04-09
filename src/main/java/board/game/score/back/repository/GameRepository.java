package board.game.score.back.repository;

import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import board.game.score.back.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {
    Game findById(Long id);

}
