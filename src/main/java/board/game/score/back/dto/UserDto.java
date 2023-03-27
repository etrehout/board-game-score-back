package board.game.score.back.dto;

import board.game.score.back.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private Long id;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Role role;
	
}
