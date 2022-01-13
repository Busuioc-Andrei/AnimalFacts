package demo.service;

import demo.models.Animal;
import demo.models.Fact;
import demo.repository.AnimalRepository;
import demo.repository.FactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RandomService {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private FactRepository factRepository;

    public List<Fact> getRandomFacts(int count){
        try {
            List<Fact> allFacts = (List<Fact>) factRepository.findAll();
            return getRandomFacts(allFacts, count);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.randomFactCouldNotBeRead();
            }
        }
    }

    public List<Fact> getRandomFactsForAnimalName(String animalName, int count){
        try {
            Optional<Animal> ifExistingAnimal = animalRepository.findByName(animalName);
            if (ifExistingAnimal.isEmpty()) {
                throw CustomException.animalCouldNotBeFound();
            }
            List<Fact> animalFacts = factRepository.findAllByAnimal(ifExistingAnimal.get());
            return getRandomFacts(animalFacts, count);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.randomFactCouldNotBeRead();
            }
        }
    }

    private List<Fact> getRandomFacts(List<Fact> facts, int count){
        Collections.shuffle(facts);
        return facts.subList(0, Math.min(count, facts.size()));
    }
}
