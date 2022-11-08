package com.example.demo.dao.orders;

import com.example.demo.model.Orders;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Orders,Long> {
}
