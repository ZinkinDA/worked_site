package com.example.demo.dao.role;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class RoleDaoImpl implements RoleDao, JpaRepository<Role,Long> {
    @PersistenceContext
    private EntityManager entityManager;
}
