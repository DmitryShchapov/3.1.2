package ru.kata.spring.boot_security.demo.dao;


import org.springframework.security.core.userdetails.UserDetails;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);

    User getUser(long id);

    void deleteUserById(long id);

    UserDetails findUserByUsername(String username);

}
