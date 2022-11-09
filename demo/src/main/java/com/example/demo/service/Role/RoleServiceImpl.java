package com.example.demo.service.Role;

import com.example.demo.dao.role.RoleDao;
import com.example.demo.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleDao roleDao;
    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public List<Role> findAll(){
        return roleDao.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleDao.findById(id);
    }
}
