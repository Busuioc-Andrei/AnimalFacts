package demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "suggestion")
public class Suggestion extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="animal_id")
    private Animal animal;

    @OneToOne
    @JoinColumn(name="fact_id", referencedColumnName = "id")
    private Fact fact;

    @Column(name = "submitter_alias",length = 50)
    private String submitterAlias;

    @Lob
    @Column
    private String description;

    @Column
    private Boolean approved = false;

    @Column
    private Boolean rejected = false;

    public Suggestion(Long id, Animal animal, Fact fact, String submitterAlias, String description, Boolean approved, Boolean rejected, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.animal = animal;
        this.fact = fact;
        this.submitterAlias = submitterAlias;
        this.description = description;
        this.approved = approved;
        this.rejected = rejected;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Suggestion(){

    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public String getSubmitterAlias() {
        return submitterAlias;
    }

    public void setSubmitterAlias(String submitterAlias) {
        this.submitterAlias = submitterAlias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getRejected() {
        return rejected;
    }

    public void setRejected(Boolean rejected) {
        this.rejected = rejected;
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Suggestion suggestion = (Suggestion) model;
            this.submitterAlias = suggestion.getSubmitterAlias();
            this.description = suggestion.getDescription();
            this.approved = suggestion.getApproved();
            this.rejected = suggestion.getRejected();
            this.modifiedAt = LocalDateTime.now();
        }
    }
}
