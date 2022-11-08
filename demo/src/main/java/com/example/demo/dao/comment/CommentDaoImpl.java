package com.example.demo.dao.comment;

import com.example.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class CommentDaoImpl implements CommentDao, JpaRepository<Comment,Long> {
    @PersistenceContext
    private EntityManager entityManager;
}
