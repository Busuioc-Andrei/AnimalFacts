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
    public ResponseEntity<List<Suggestion>> getSuggestions(@RequestHeader(Credentials.AUTHORIZATION) String header){
        Credentials credentials = new Credentials(header);
        List<Suggestion> suggestions = service.readQueue(credentials);
        return suggestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(suggestions);
    }

    @PutMapping("/{suggestion_id}/approve")
    public ResponseEntity<Void> approveSuggestion(@RequestHeader(Credentials.AUTHORIZATION) String header,
                                                  @PathVariable("suggestion_id") Long suggestionId){
        Credentials credentials = new Credentials(header);
        service.approveSuggestion(credentials, suggestionId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{suggestion_id}/reject")
    public ResponseEntity<Void> rejectSuggestion(@RequestHeader(Credentials.AUTHORIZATION) String header,
                                                 @PathVariable("suggestion_id") Long suggestionId){
        Credentials credentials = new Credentials(header);
        service.rejectSuggestion(credentials, suggestionId);
        return ResponseEntity.noContent().build();
    }

}
