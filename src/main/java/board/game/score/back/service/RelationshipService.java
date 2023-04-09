package board.game.score.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.game.score.back.entity.Relationship;
import board.game.score.back.repository.RelationshipRepository;

@Service
public class RelationshipService {

    @Autowired
    private RelationshipRepository relationshipRepository;

    public List<Relationship> getAllRelationships() {
        return relationshipRepository.findAll();
    }

}
