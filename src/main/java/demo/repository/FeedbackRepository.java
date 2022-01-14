package demo.repository;

import demo.models.Feedback;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends BaseModelRepository<Feedback> {
}