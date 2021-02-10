package com.mate.service;

import com.mate.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User get(Long id);
}
