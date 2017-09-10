package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.User;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByEmail(String email);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
