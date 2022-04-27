package demo;

import demo.models.Animal;
import demo.repository.*;
import demo.service.Credentials;
import demo.service.CrudService;
import demo.service.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrudServiceTest {

    @InjectMocks
    private CrudService crudService;
    @Mock
    private AnimalRepository animalRepository;

    private static Optional<Animal> animal;
    private static List<Animal> animals = new ArrayList<>();
    private static LocalDateTime now = LocalDateTime.now();

    @BeforeAll
    public static void setup() {
        animal = Optional.of(new Animal(1L, null, "panda", LocalDateTime.now(), LocalDateTime.now()));
        animals.add(animal.get());
    }

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(crudService, "adminName", "admin");
        ReflectionTestUtils.setField(crudService, "adminPassword", "testpass");
    }

    @Test
    public void testAnimalCreationHappy() {
        when(animalRepository.save(any())).thenReturn(null);
        crudService.create(animal.get());
    }

    @Test
    public void testAnimalCreationUnHappy() {
        when(animalRepository.save(any())).thenReturn(null);
        crudService.create(animal.get());
    }

    @Test
    public void testAnimalReadHappy() {
        when(animalRepository.findById(animal.get().getId())).thenReturn(animal);
        Animal expectedAnimal = animal.get();
        Animal actualAnimal = crudService.read(Animal.class, animal.get().getId());
        assertEquals(expectedAnimal, actualAnimal);
    }

    @Test
    public void testAnimalReadUnHappy() {
        when(animalRepository.findById(animal.get().getId())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> crudService.read(Animal.class, animal.get().getId()));
        assertEquals(CustomException.ErrorCode.OBJECT_COULD_NOT_BE_FOUND, exception.getError());
    }

    @Test
    public void testAnimalReadListHappy() {
        when(animalRepository.findAll()).thenReturn(animals);
        List<Animal> expectedAnimals = animals;
        List<Animal> actualAnimals = crudService.readList(Animal.class);
        assertEquals(expectedAnimals, actualAnimals);
    }

    @Test
    public void testAnimalUpdateHappy() {
        when(animalRepository.findById(animal.get().getId())).thenReturn(animal);
        when(animalRepository.save(any())).thenReturn(null);
        crudService.update(animal.get());
    }

    @Test
    public void testAnimalDeleteHappy() {
        when(animalRepository.findById(animal.get().getId())).thenReturn(animal);
        crudService.delete(Animal.class, animal.get().getId());
    }
}
