package demo.repository;

import demo.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseModelRepository<User> {
    User findByUsername(String username);
}