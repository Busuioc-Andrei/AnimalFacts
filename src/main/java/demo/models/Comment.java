package demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fact_id")
    @JsonIgnore
    private Fact fact;

    @Column(name = "submitter_alias",length = 50)
    private String submitterAlias;

    @Column(length = 500)
    private String content;

    public Comment(Long id, Fact fact, String submitterAlias, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.fact = fact;
        this.submitterAlias = submitterAlias;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Comment(){

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Comment comment = (Comment) model;
            this.submitterAlias = comment.getSubmitterAlias();
            this.content = comment.getContent();
            this.modifiedAt = LocalDateTime.now();
        }
    }
}
