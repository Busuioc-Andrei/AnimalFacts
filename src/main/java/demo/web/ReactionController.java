package demo.web;

import demo.models.Comment;
import demo.models.Feedback;
import demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reaction")
public class ReactionController {

    @Autowired
    private ReactionService service;

    @PostMapping("/comment/fact/{fact_id}")
    public ResponseEntity<Void> sendComment(@PathVariable("fact_id") Long factId,
                                            @RequestBody Comment comment){
        service.saveComment(factId, comment);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/feedback/fact/{fact_id}")
    public ResponseEntity<Void> sendFeedback(@PathVariable("fact_id") Long factId,
                                            @RequestBody Feedback feedback){
        service.saveFeedback(factId, feedback);
        return ResponseEntity.noContent().build();
    }
}
