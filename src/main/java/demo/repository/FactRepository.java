package demo.repository;

import demo.models.Animal;
import demo.models.Fact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactRepository extends BaseModelRepository<Fact> {
    List<Fact> findAllByAnimal(Animal animal);
}