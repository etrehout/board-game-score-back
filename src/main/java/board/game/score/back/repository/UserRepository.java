package board.game.score.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import board.game.score.back.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

}
