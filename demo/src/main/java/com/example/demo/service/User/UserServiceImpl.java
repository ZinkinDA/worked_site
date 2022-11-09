package com.example.demo.service.User;

import com.example.demo.dao.user.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public Optional<User> findById(Long id){
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public void saveUser(User user){
        userDao.save(user);
    }

    @Override
    public void deleteAccount(Long id) {
        userDao.deleteById(id);
    }
}
