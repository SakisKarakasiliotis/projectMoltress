package com.concretepage.dao;

import java.util.List;

import com.concretepage.entity.User;

public interface IUserDAO {
    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByEmail(String email);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);

    boolean userExists(String email);
}
