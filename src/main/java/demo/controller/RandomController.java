package demo.controller;

import demo.models.Fact;
import demo.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/random")
public class RandomController {

    @Autowired
    private RandomService service;

    @GetMapping("/fact")
    public ResponseEntity<List<Fact>> getRandomFacts(@RequestParam(defaultValue="1") int count){
        List<Fact> facts = service.getRandomFacts(count);
        return facts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(facts);
    }

    @GetMapping("/{animal}/fact")
    public ResponseEntity<List<Fact>> getRandomFacts(@PathVariable("animal") String animalName,
                                                     @RequestParam(defaultValue="1") int count){

        List<Fact> facts = service.getRandomFactsForAnimalName(animalName, count);
        return facts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(facts);
    }
}
