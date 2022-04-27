package demo.interfaces;

import demo.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}