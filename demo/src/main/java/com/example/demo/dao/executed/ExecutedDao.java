package com.example.demo.dao.executed;

import com.example.demo.model.Executed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExecutedDao extends JpaRepository<Executed,Long> {
}
