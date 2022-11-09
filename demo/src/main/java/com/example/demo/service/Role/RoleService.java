package com.example.demo.service.Role;

import com.example.demo.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);

    List<Role> findAll();
}
