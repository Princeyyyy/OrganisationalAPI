package DAO;

import models.User;

import java.util.List;

public interface UserDAO {

    void add(User user);

    List<User> getAllUsers();

    User getUserById(int id);
}
