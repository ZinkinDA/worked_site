package com.example.demo.service.Role;

import com.example.demo.dao.role.RoleDao;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService{
    private final RoleDao roleDao;
    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAll(){
        return roleDao.findAll();
    }
}
