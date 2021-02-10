package com.mate.dao;

import com.mate.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();

    User get(Long id);
}
