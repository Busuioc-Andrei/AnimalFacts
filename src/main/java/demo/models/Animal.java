package demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "animal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Animal extends BaseModel{

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Image> images;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Column(length = 500)
    private String imageUrl;

    public Animal(Long id, List<Image> images, String imageUrl, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.images = images;
        this.imageUrl = imageUrl;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Animal(){

    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(BaseModel model) {
        if(model != null) {
            Animal animal = (Animal) model;
            this.name = animal.getName();
            this.imageUrl = animal.getImageUrl();
            this.modifiedAt = LocalDateTime.now();
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
