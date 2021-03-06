package com.mate.service;

import com.mate.dao.UserDao;
import com.mate.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAll();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id).get();
    }
}
