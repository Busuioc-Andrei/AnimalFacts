package demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "fact")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Fact extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animal animal;

    @OneToMany(mappedBy = "fact", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Comment> comments;

    @OneToMany(mappedBy = "fact", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Feedback> feedbacks;

    @Lob
    @Column
    private String description;

    public Fact(Long id, Animal animal, List<Comment> comments, List<Feedback> feedbacks, String description, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.animal = animal;
        this.comments = comments;
        this.feedbacks = feedbacks;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Fact(Suggestion suggestion){
        this.animal = suggestion.getAnimal();
        this.description = suggestion.getDescription();
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }

    public Fact(){

    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLikes() {
        return this.feedbacks.stream()
                .filter(Feedback::getLiked)
                .count();
    }

    public Long getDislikes() {
        return this.feedbacks.size() - getLikes();
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Fact fact = (Fact) model;
            this.description = fact.getDescription();
            this.modifiedAt = LocalDateTime.now();
        }
    }
}
