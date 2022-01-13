package demo.repository;

import demo.models.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends BaseModelRepository<Animal> {
    Optional<Animal> findByName(String name);
}