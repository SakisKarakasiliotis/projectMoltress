package com.concretepage.service;
import java.util.List;

import com.concretepage.entity.User;

public interface IUserService {
    List<User> getAllUsers();

    User getUserById(int userId);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
