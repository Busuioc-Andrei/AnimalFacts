package demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "image")
public class Image extends BaseModel{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="animal_id")
    @JsonIgnore
    private Animal animal;

    @Column(length = 500)
    private String url;

    public Image(Long id, Animal animal, String url, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.animal = animal;
        this.url = url;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Image(){

    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Image image = (Image) model;
            this.url = image.getUrl();
            this.modifiedAt = LocalDateTime.now();
        }
    }
}
