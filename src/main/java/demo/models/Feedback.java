package demo.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
public class Feedback extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fact_id")
    private Fact fact;

    @Column(name = "submitter_alias",length = 50)
    private String submitterAlias;

    @Column
    private Boolean liked;

    public Feedback(Long id, Fact fact, String submitterAlias, Boolean liked, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.fact = fact;
        this.submitterAlias = submitterAlias;
        this.liked = liked;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Feedback(){
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

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Feedback feedback = (Feedback) model;
            this.submitterAlias = feedback.getSubmitterAlias();
            this.liked = feedback.getLiked();
            this.modifiedAt = LocalDateTime.now();
        }
    }
}
