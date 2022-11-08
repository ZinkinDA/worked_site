package com.example.demo.dao.orders;

import com.example.demo.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class OrderDaoImpl implements OrderDao, JpaRepository<Orders,Long> {
    @PersistenceContext
    private EntityManager entityManager;
}
