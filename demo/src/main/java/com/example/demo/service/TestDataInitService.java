package com.example.demo.service;

import com.example.demo.dao.role.RoleDao;
import com.example.demo.dao.user.UserDao;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestDataInitService {
    private final RoleDao roleDao;
    private final UserDao userDao;
    @Autowired
    public TestDataInitService(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        InitUserAndRoles();
    }

    public void InitUserAndRoles() {
        Role roleUser = Role.builder()
                .name("CLIENT").build();
        Role roleAdmin = Role.builder()
                .name("ADMIN").build();
        Role roleRoot = Role.builder()
                .name("MODERATOR").build();
        roleDao.saveAll(List.of(roleUser, roleAdmin, roleRoot));

        User root = User.builder()
                .name("Dmitry").surname("Zinkin")
                .email("yashtlsht@mail.ru")
                .password("moderator")
                .Reputation(0L)
                .role(roleRoot)
                .executed(new ArrayList<>())
                .ordersList(new ArrayList<>())
                .build();
        userDao.save(root);
        User admin = User.builder()
                .name("Admin").surname("Web-site")
                .email("admin@mail.ru")
                .password("admin")
                .Reputation(0L)
                .role(roleAdmin)
                .executed(new ArrayList<>())
                .ordersList(new ArrayList<>())
                .build();
        userDao.save(admin);
        User user = User.builder()
                .name("User").surname("Web-site")
                .email("user@mail.ru")
                .password("user")
                .Reputation(0L)
                .role(roleUser)
                .executed(new ArrayList<>())
                .ordersList(new ArrayList<>())
                .build();
        userDao.save(user);

    }
}
