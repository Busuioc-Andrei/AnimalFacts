package demo.repository;

import demo.models.Image;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends BaseModelRepository<Image> {
}