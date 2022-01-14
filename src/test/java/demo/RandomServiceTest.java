package demo;

import demo.models.Animal;
import demo.models.Fact;
import demo.repository.AnimalRepository;
import demo.repository.FactRepository;
import demo.service.CustomException;
import demo.service.RandomService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RandomServiceTest {

    @InjectMocks
    private RandomService randomService;
    @Mock
    private AnimalRepository animalRepository;
    @Mock
    private FactRepository factRepository;

    private static Optional<Animal> animal;
    private static List<Fact> facts;
    private static List<Fact> emptyFacts;
    private static LocalDateTime now = LocalDateTime.now();

    @BeforeAll
    public static void setup() {
        animal = Optional.of(new Animal(1L, null, "panda", now, now));
        emptyFacts = new ArrayList<>();
        facts = new ArrayList<>();
        facts.add(new Fact(1L, animal.get(), null, null, "Giant pandas spend 10-16 hours a day feeding, mainly on bamboo.", now, now));
    }

    @Test
    public void testAnimalDoesNotExist() {
        when(animalRepository.findByName(animal.get().getName())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> randomService.getRandomFactsForAnimalName(animal.get().getName(), 1));
        assertEquals(CustomException.ErrorCode.ANIMAL_COULD_NOT_BE_FOUND, exception.getError());
    }

    @Test
    public void testNoFactsExist() {
        when(factRepository.findAll()).thenReturn(emptyFacts);
        List<Fact> expectedFacts = new ArrayList<>();
        List<Fact> actualFacts = randomService.getRandomFacts(1);
        assertEquals(expectedFacts, actualFacts);
    }

    @Test
    public void testCountParameterLargerThanActualFactCount() {
        when(factRepository.findAll()).thenReturn(facts);
        int largerFactCount = facts.size() + 5;
        int expectedFactCount = facts.size();
        int actualFactCount = randomService.getRandomFacts(largerFactCount).size();
        assertEquals(expectedFactCount, actualFactCount);
    }

    @Test
    public void testGetFactsHappy() {
        when(factRepository.findAll()).thenReturn(facts);
        List<Fact> expectedFacts = facts;
        List<Fact> actualFacts = randomService.getRandomFacts(facts.size());
        assertEquals(expectedFacts, actualFacts);
    }

}
