package demo;

import demo.models.Animal;
import demo.models.Fact;
import demo.models.Suggestion;
import demo.repository.AnimalRepository;
import demo.repository.FactRepository;
import demo.repository.SuggestionRepository;
import demo.service.Credentials;
import demo.service.CustomException;
import demo.service.RecommendationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceTest {

    @InjectMocks
    private RecommendationService recommendationService;
    @Mock
    private AnimalRepository animalRepository;
    @Mock
    private FactRepository factRepository;
    @Mock
    private SuggestionRepository suggestionRepository;

    private static Optional<Animal> animal;
    private static Optional<Suggestion> suggestion;
    private static Optional<Suggestion> suggestionApproved;
    private static LocalDateTime now = LocalDateTime.now();

    @BeforeAll
    public static void setup() {

        animal = Optional.of(new Animal(1L, null, "a","panda", LocalDateTime.now(), LocalDateTime.now()));
        suggestion = Optional.of(new Suggestion(1L, animal.get(), null, "Jim", "Pandas need at least 2 different bamboo species in their range to avoid starvation", false, false, now, now));
        suggestionApproved = Optional.of(new Suggestion(2L, animal.get(), null, "Jim", "Pandas need at least 2 different bamboo species in their range to avoid starvation", true, false, now, now));

    }

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(recommendationService, "adminName", "admin");
        ReflectionTestUtils.setField(recommendationService, "adminPassword", "testpass");
    }

    @Test
    public void testAnimalDoesNotExist() {
        when(animalRepository.findByName(animal.get().getName())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> recommendationService.makeSuggestion(animal.get().getName(), suggestion.get()));
        assertEquals(CustomException.ErrorCode.ANIMAL_COULD_NOT_BE_FOUND, exception.getError());
    }

    @Test
    public void testSuggestionDoesNotExist() {
        when(suggestionRepository.findById(suggestion.get().getId())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> recommendationService.approveSuggestion(suggestion.get().getId()));
        assertEquals(CustomException.ErrorCode.SUGGESTION_COULD_NOT_BE_FOUND, exception.getError());
    }

    @Test
    public void testSuggestionAlreadyApproved() {
        when(suggestionRepository.findById(suggestionApproved.get().getId())).thenReturn(suggestionApproved);
        CustomException exception = assertThrows(CustomException.class,
                () -> recommendationService.approveSuggestion(suggestionApproved.get().getId()));
        assertEquals(CustomException.ErrorCode.SUGGESTION_ALREADY_APPROVED, exception.getError());
    }

    @Test
    public void testSuggestionSuccessfullyApprovedHappy() {
        when(suggestionRepository.findById(suggestion.get().getId())).thenReturn(suggestion);
        when(suggestionRepository.save(any())).thenReturn(null);
        when(factRepository.save(any())).thenReturn(null);
        recommendationService.approveSuggestion(suggestion.get().getId());
    }
}
