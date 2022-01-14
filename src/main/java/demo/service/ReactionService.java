package demo.service;

import demo.models.*;
import demo.repository.CommentRepository;
import demo.repository.FactRepository;
import demo.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReactionService {

    @Autowired
    private FactRepository factRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Transactional
    public void saveComment(Long factId, Comment comment){
        try {
            Fact fact = getValidFact(factId);
            comment.setFact(fact);
            comment.setCreatedAt(LocalDateTime.now());
            comment.setModifiedAt(LocalDateTime.now());
            commentRepository.save(comment);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.commentCouldNotBeCreated();
            }
        }
    }

    @Transactional
    public void saveFeedback(Long factId, Feedback feedback){
        try {
            Fact fact = getValidFact(factId);
            feedback.setFact(fact);
            feedback.setCreatedAt(LocalDateTime.now());
            feedback.setModifiedAt(LocalDateTime.now());
            feedbackRepository.save(feedback);
        }
        catch (RuntimeException e) {
            if (e instanceof CustomException) {
                throw e;
            } else {
                throw CustomException.feedbackCouldNotBeCreated();
            }
        }
    }

    private Fact getValidFact(Long factId){
        Optional<Fact> ifExistingFact = factRepository.findById(factId);
        if (ifExistingFact.isEmpty()) {
            throw CustomException.factCouldNotBeFound();
        }
        return ifExistingFact.get();
    }
}
