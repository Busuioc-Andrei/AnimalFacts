package demo.repository;

import demo.models.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends BaseModelRepository<Comment> {
}