package app.dao;

import app.model.Role;
import app.model.User;
import java.util.List;
import java.util.Set;

public interface UserDao {
    void add(User user);
    void delete(long id);
    void change(User user, Set<Role> roles);
    List<User> listUsers();
    User findUserById(long id);
    public User findUserByEmail (String email);
}
