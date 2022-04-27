package demo.web;

import demo.models.*;
import demo.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CrudController {

    @Autowired
    private CrudService service;

    @GetMapping("/animal/add")
    public String showAddAnimalForm(Animal animal){
        return "add-animal";
    }

    @PostMapping("/animal/add")
    public String postAnimal(@Valid Animal animal, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-animal";
        }
        service.create(animal);
        return "redirect:/animal";
    }

    @GetMapping("/animal/edit/{id}")
    public String showUpdateAnimalForm(@PathVariable("id") long id, Model model) {
        Animal animal = service.read(Animal.class, id);

        model.addAttribute("animal", animal);
        return "update-animal";
    }

    @PostMapping("/animal/update/{id}")
    public String updateAnimal(@PathVariable("id") long id, @Valid Animal animal,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            animal.setId(id);
            return "update-animal";
        }

        service.update(animal);
        return "redirect:/animal";
    }

    @GetMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable("id") long id, Model model) {
        service.delete(Animal.class, id);
        return "redirect:/animal";
    }

    @GetMapping("/animal")
    public String showAnimals(Model model) {
        List<Animal> animals = service.readList(Animal.class);
        model.addAttribute("animals", animals);
        return "animal";
    }

    @GetMapping("/fact/add")
    public String showAddFactForm(Fact fact, Model model){
        List<Animal> listAnimals = service.readList(Animal.class);
        model.addAttribute("listAnimals", listAnimals);
        return "add-fact";
    }

    @PostMapping("/fact/add")
    public String postFact(@Valid Fact fact, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-fact";
        }
        service.create(fact);
        return "redirect:/fact";
    }

    @GetMapping("/fact/edit/{id}")
    public String showUpdateFactForm(@PathVariable("id") long id, Model model) {
        Fact fact = service.read(Fact.class, id);
        model.addAttribute("fact", fact);
        List<Animal> listAnimals = service.readList(Animal.class);
        model.addAttribute("listAnimals", listAnimals);
        return "update-fact";
    }

    @PostMapping("/fact/update/{id}")
    public String updateFact(@PathVariable("id") long id, @Valid Fact fact,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            fact.setId(id);
            return "update-fact";
        }

        service.update(fact);
        return "redirect:/fact";
    }

    @GetMapping("/fact/delete/{id}")
    public String deleteFact(@PathVariable("id") long id, Model model) {
        service.delete(Fact.class, id);
        return "redirect:/fact";
    }

    @GetMapping("/fact")
    public String showFacts(Model model) {
        List<Fact> facts = service.readList(Fact.class);
        model.addAttribute("facts", facts);
        return "fact";
    }


    //comment
//    @PostMapping("/comment")
//    public ResponseEntity<Void> postComment(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                            @RequestBody Comment comment){
//        Credentials credentials = new Credentials(header);
//        service.create(credentials, comment);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/comment")
//    public ResponseEntity<Comment> getComments(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                               @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        Comment comment = service.read(credentials, Comment.class, id);
//        return ResponseEntity.ok(comment);
//    }
//
//    @GetMapping("/comments")
//    public ResponseEntity<List<Comment>> getComments(@RequestHeader(Credentials.AUTHORIZATION) String header){
//        Credentials credentials = new Credentials(header);
//        List<Comment> comments = service.readList(credentials, Comment.class);
//        return comments.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(comments);
//    }
//
//    @PutMapping("/comment")
//    public ResponseEntity<List<Comment>> putComment(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                    @RequestBody Comment comment){
//        Credentials credentials = new Credentials(header);
//        service.update(credentials, comment);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/comment")
//    public ResponseEntity<List<Comment>> deleteComment(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                       @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        service.delete(credentials, Comment.class, id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //fact
//    @PostMapping("/fact")
//    public ResponseEntity<Void> postFact(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                         @RequestBody Fact fact){
//        Credentials credentials = new Credentials(header);
//        service.create(credentials, fact);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/fact")
//    public ResponseEntity<Fact> getFacts(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                         @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        Fact fact = service.read(credentials, Fact.class, id);
//        return ResponseEntity.ok(fact);
//    }
//
//    @GetMapping("/facts")
//    public ResponseEntity<List<Fact>> getFacts(@RequestHeader(Credentials.AUTHORIZATION) String header){
//        Credentials credentials = new Credentials(header);
//        List<Fact> facts = service.readList(credentials, Fact.class);
//        return facts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(facts);
//    }
//
//    @PutMapping("/fact")
//    public ResponseEntity<List<Fact>> putFact(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                              @RequestBody Fact fact){
//        Credentials credentials = new Credentials(header);
//        service.update(credentials, fact);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/fact")
//    public ResponseEntity<List<Fact>> deleteFact(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                 @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        service.delete(credentials, Fact.class, id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //feedback
//    @PostMapping("/feedback")
//    public ResponseEntity<Void> postFeedback(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                             @RequestBody Feedback feedback){
//        Credentials credentials = new Credentials(header);
//        service.create(credentials, feedback);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/feedback")
//    public ResponseEntity<Feedback> getFeedbacks(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                 @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        Feedback feedback = service.read(credentials, Feedback.class, id);
//        return ResponseEntity.ok(feedback);
//    }
//
//    @GetMapping("/feedbacks")
//    public ResponseEntity<List<Feedback>> getFeedbacks(@RequestHeader(Credentials.AUTHORIZATION) String header){
//        Credentials credentials = new Credentials(header);
//        List<Feedback> feedbacks = service.readList(credentials, Feedback.class);
//        return feedbacks.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(feedbacks);
//    }
//
//    @PutMapping("/feedback")
//    public ResponseEntity<List<Feedback>> putFeedback(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                      @RequestBody Feedback feedback){
//        Credentials credentials = new Credentials(header);
//        service.update(credentials, feedback);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/feedback")
//    public ResponseEntity<List<Feedback>> deleteFeedback(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                         @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        service.delete(credentials, Feedback.class, id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //image
//    @PostMapping("/image")
//    public ResponseEntity<Void> postImage(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                          @RequestBody Image image){
//        Credentials credentials = new Credentials(header);
//        service.create(credentials, image);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/image")
//    public ResponseEntity<Image> getImages(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                           @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        Image image = service.read(credentials, Image.class, id);
//        return ResponseEntity.ok(image);
//    }
//
//    @GetMapping("/images")
//    public ResponseEntity<List<Image>> getImages(@RequestHeader(Credentials.AUTHORIZATION) String header){
//        Credentials credentials = new Credentials(header);
//        List<Image> images = service.readList(credentials, Image.class);
//        return images.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(images);
//    }
//
//    @PutMapping("/image")
//    public ResponseEntity<List<Image>> putImage(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                @RequestBody Image image){
//        Credentials credentials = new Credentials(header);
//        service.update(credentials, image);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/image")
//    public ResponseEntity<List<Image>> deleteImage(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                   @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        service.delete(credentials, Image.class, id);
//        return ResponseEntity.noContent().build();
//    }
//
//    //suggestion
//    @PostMapping("/suggestion")
//    public ResponseEntity<Void> postSuggestion(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                               @RequestBody Suggestion suggestion){
//        Credentials credentials = new Credentials(header);
//        service.create(credentials, suggestion);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/suggestion")
//    public ResponseEntity<Suggestion> getSuggestions(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                     @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        Suggestion suggestion = service.read(credentials, Suggestion.class, id);
//        return ResponseEntity.ok(suggestion);
//    }
//
//    @GetMapping("/suggestions")
//    public ResponseEntity<List<Suggestion>> getSuggestions(@RequestHeader(Credentials.AUTHORIZATION) String header){
//        Credentials credentials = new Credentials(header);
//        List<Suggestion> suggestions = service.readList(credentials, Suggestion.class);
//        return suggestions.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(suggestions);
//    }
//
//    @PutMapping("/suggestion")
//    public ResponseEntity<List<Suggestion>> putSuggestion(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                          @RequestBody Suggestion suggestion){
//        Credentials credentials = new Credentials(header);
//        service.update(credentials, suggestion);
//        return ResponseEntity.noContent().build();
//    }
//
//    @DeleteMapping("/suggestion")
//    public ResponseEntity<List<Suggestion>> deleteSuggestion(@RequestHeader(Credentials.AUTHORIZATION) String header,
//                                                             @RequestParam Long id){
//        Credentials credentials = new Credentials(header);
//        service.delete(credentials, Suggestion.class, id);
//        return ResponseEntity.noContent().build();
//    }
}
