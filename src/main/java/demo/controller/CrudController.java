package demo.controller;

import demo.models.*;
import demo.service.Credentials;
import demo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private CrudService service;

    //animal
    @PostMapping("/animal")
    public ResponseEntity<Void> postAnimal(@RequestBody Animal animal){
        service.create(animal);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/animal")
    public ResponseEntity<Animal> getAnimals(@RequestParam Long id){
        Animal animal = service.read(Animal.class, id);
        return ResponseEntity.ok(animal);
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAnimals(){
        List<Animal> animals = service.readList(Animal.class);
        return animals.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(animals);
    }

    @PutMapping("/animal")
    public ResponseEntity<List<Animal>> putAnimal(@RequestBody Animal animal){
        service.update(animal);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/animal")
    public ResponseEntity<List<Animal>> deleteAnimal(@RequestParam Long id){
        service.delete(Animal.class, id);
        return ResponseEntity.noContent().build();
    }

    //comment
    @PostMapping("/comment")
    public ResponseEntity<Void> postComment(@RequestBody Comment comment){
        service.create(comment);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/comment")
    public ResponseEntity<Comment> getComments(@RequestParam Long id){
        Comment comment = service.read(Comment.class, id);
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments(){
        List<Comment> comments = service.readList(Comment.class);
        return comments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(comments);
    }

    @PutMapping("/comment")
    public ResponseEntity<List<Comment>> putComment(@RequestBody Comment comment){
        service.update(comment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comment")
    public ResponseEntity<List<Comment>> deleteComment(@RequestParam Long id){
        service.delete(Comment.class, id);
        return ResponseEntity.noContent().build();
    }

    //fact
    @PostMapping("/fact")
    public ResponseEntity<Void> postFact(@RequestBody Fact fact){
        service.create(fact);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{animal_id}/fact")
    public ResponseEntity<Void> postAnimalFact(@PathVariable("animal_id") Long animal_id, @RequestBody Fact fact){
        Animal animal = service.read(Animal.class, animal_id);
        fact.setAnimal(animal);
        service.create(fact);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/fact")
    public ResponseEntity<Fact> getFacts(@RequestParam Long id){
        Fact fact = service.read(Fact.class, id);
        return ResponseEntity.ok(fact);
    }

    @GetMapping("/facts")
    public ResponseEntity<List<Fact>> getFacts(){
        List<Fact> facts = service.readList(Fact.class);
        return facts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(facts);
    }

    @PutMapping("/fact")
    public ResponseEntity<List<Fact>> putFact(@RequestBody Fact fact){
        service.update(fact);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/fact")
    public ResponseEntity<List<Fact>> deleteFact(@RequestParam Long id){
        service.delete(Fact.class, id);
        return ResponseEntity.noContent().build();
    }

    //feedback
    @PostMapping("/feedback")
    public ResponseEntity<Void> postFeedback(@RequestBody Feedback feedback){
        service.create(feedback);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/feedback")
    public ResponseEntity<Feedback> getFeedbacks(@RequestParam Long id){
        Feedback feedback = service.read(Feedback.class, id);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> getFeedbacks(){
        List<Feedback> feedbacks = service.readList(Feedback.class);
        return feedbacks.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(feedbacks);
    }

    @PutMapping("/feedback")
    public ResponseEntity<List<Feedback>> putFeedback(@RequestBody Feedback feedback){
        service.update(feedback);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/feedback")
    public ResponseEntity<List<Feedback>> deleteFeedback(@RequestParam Long id){
        service.delete(Feedback.class, id);
        return ResponseEntity.noContent().build();
    }

    //image
    @PostMapping("/image")
    public ResponseEntity<Void> postImage(@RequestBody Image image){
        service.create(image);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/image")
    public ResponseEntity<Image> getImages(@RequestParam Long id){
        Image image = service.read(Image.class, id);
        return ResponseEntity.ok(image);
    }

    @GetMapping("/images")
    public ResponseEntity<List<Image>> getImages(){
        List<Image> images = service.readList(Image.class);
        return images.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(images);
    }

    @PutMapping("/image")
    public ResponseEntity<List<Image>> putImage(@RequestBody Image image){
        service.update(image);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/image")
    public ResponseEntity<List<Image>> deleteImage(@RequestParam Long id){
        service.delete(Image.class, id);
        return ResponseEntity.noContent().build();
    }

    //suggestion
    @PostMapping("/suggestion")
    public ResponseEntity<Void> postSuggestion(@RequestBody Suggestion suggestion){
        service.create(suggestion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/suggestion")
    public ResponseEntity<Suggestion> getSuggestions(@RequestParam Long id){
        Suggestion suggestion = service.read(Suggestion.class, id);
        return ResponseEntity.ok(suggestion);
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<Suggestion>> getSuggestions(){
        List<Suggestion> suggestions = service.readList(Suggestion.class);
        return suggestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(suggestions);
    }

    @PutMapping("/suggestion")
    public ResponseEntity<List<Suggestion>> putSuggestion(@RequestBody Suggestion suggestion){
        service.update(suggestion);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/suggestion")
    public ResponseEntity<List<Suggestion>> deleteSuggestion(@RequestParam Long id){
        service.delete(Suggestion.class, id);
        return ResponseEntity.noContent().build();
    }
}
