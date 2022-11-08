package com.example.demo.dao.image;

import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class ImageDaoImpl implements ImageDao, JpaRepository<Image,Long> {
    @PersistenceContext
    private EntityManager entityManager;
}
