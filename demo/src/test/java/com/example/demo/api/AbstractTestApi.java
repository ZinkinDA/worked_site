package com.example.demo.api;

import com.example.demo.DemoApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@DBRider
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource(properties = {"spring.config.location = src/test/resources/application-test.properties"})
@DBUnit(caseSensitiveTableNames = true, cacheConnection = false, allowEmptyFields = true)
@AutoConfigureMockMvc
public abstract class AbstractTestApi {

    @Autowired
    protected MockMvc mvc;
    
    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected ObjectMapper objectMapper;


}
