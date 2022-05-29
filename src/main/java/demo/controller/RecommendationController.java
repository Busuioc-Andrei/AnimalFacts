package demo.controller;

import demo.models.Suggestion;
import demo.service.Credentials;
import demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @PostMapping("/{animal}/fact")
    public ResponseEntity<Void> postSuggestion(@PathVariable("animal") String animalName,
                                                     @RequestBody Suggestion suggestion){
        service.makeSuggestion(animalName, suggestion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/queue")
    public ResponseEntity<List<Suggestion>> getSuggestions(){
        List<Suggestion> suggestions = service.readQueue();
        return suggestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(suggestions);
    }

    @PutMapping("/{suggestion_id}/approve")
    public ResponseEntity<Void> approveSuggestion(@PathVariable("suggestion_id") Long suggestionId){
        service.approveSuggestion(suggestionId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{suggestion_id}/reject")
    public ResponseEntity<Void> rejectSuggestion(@PathVariable("suggestion_id") Long suggestionId){
        service.rejectSuggestion(suggestionId);
        return ResponseEntity.noContent().build();
    }

}
