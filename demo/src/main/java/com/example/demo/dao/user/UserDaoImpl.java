package com.example.demo.dao.user;

import com.example.demo.model.User;
import org.hibernate.transform.ToListResultTransformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.Optional;

@Repository
public abstract class UserDaoImpl implements UserDao, JpaRepository<User,Long> {

    @PersistenceContext
    private EntityManager entityManager;

}
