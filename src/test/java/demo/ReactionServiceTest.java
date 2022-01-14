package demo;

import demo.models.Comment;
import demo.models.Fact;
import demo.models.Feedback;
import demo.repository.FactRepository;
import demo.repository.FeedbackRepository;
import demo.service.CustomException;
import demo.service.ReactionService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReactionServiceTest {

    @InjectMocks
    private ReactionService reactionService;
    @Mock
    private FactRepository factRepository;
    @Mock
    private FeedbackRepository feedbackRepository;

    private static Optional<Fact> fact;
    private static Optional<Comment> comment;
    private static Optional<Feedback> feedback;
    private static LocalDateTime now = LocalDateTime.now();

    @BeforeAll
    public static void setup() {
        fact = Optional.of(new Fact(1L, null, null, null, "Giant pandas spend 10-16 hours a day feeding, mainly on bamboo.", now, now));
        comment = Optional.of(new Comment(1L,fact.get(), "John", "I did not know that", now, now));
        feedback = Optional.of(new Feedback(1L,fact.get(), "John", true, now, now));
    }

    @Test
    public void testFactDoesNotExist() {
        when(factRepository.findById(fact.get().getId())).thenReturn(Optional.empty());
        CustomException exception = assertThrows(CustomException.class,
                () -> reactionService.saveComment(fact.get().getId(), comment.get()));
        assertEquals(CustomException.ErrorCode.FACT_COULD_NOT_BE_FOUND, exception.getError());
    }

    @Test
    public void testSaveFeedbackHappy() {
        when(factRepository.findById(fact.get().getId())).thenReturn(fact);
        when(feedbackRepository.save(any())).thenReturn(null);
        reactionService.saveFeedback(fact.get().getId(), feedback.get());
    }
}
