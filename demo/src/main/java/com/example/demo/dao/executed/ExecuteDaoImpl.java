package com.example.demo.dao.executed;

import com.example.demo.model.Executed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class ExecuteDaoImpl implements ExecutedDao, JpaRepository<Executed,Long> {
    @PersistenceContext
    private EntityManager entityManager;
}
