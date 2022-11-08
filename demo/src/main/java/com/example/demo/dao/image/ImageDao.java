package com.example.demo.dao.image;

import com.example.demo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Long> {
}
