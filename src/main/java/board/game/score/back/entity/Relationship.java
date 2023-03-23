package board.game.score.back.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIncludeProperties
public class Relationship {

	@EmbeddedId
    private RelationshipId id;

    @ManyToOne
    @JoinColumn(name = "user1_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user1Id;

    @ManyToOne
    @JoinColumn(name = "user2_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user2Id;

    private RelationshipStatus status;
    
}
