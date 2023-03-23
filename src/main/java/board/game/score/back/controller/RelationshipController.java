package board.game.score.back.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import board.game.score.back.entity.Relationship;
import board.game.score.back.service.RelationshipService;

@RestController
@RequestMapping("/relationships")
public class RelationshipController {

	@Resource(name = "relationshipService")
    private RelationshipService relationshipService;
	
    @GetMapping
    public List <Relationship> getAllRelationships() {
        return relationshipService.getAllRelationships();
    }
}
