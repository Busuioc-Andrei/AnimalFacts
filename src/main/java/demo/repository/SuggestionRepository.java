package demo.repository;

import demo.models.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionRepository extends BaseModelRepository<Suggestion> {
    List<Suggestion> findAllByApprovedEqualsAndRejectedEquals(Boolean approved, Boolean rejected);
}