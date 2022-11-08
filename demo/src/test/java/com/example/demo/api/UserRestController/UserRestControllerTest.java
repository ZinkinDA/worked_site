package com.example.demo.api.UserRestController;

import com.example.demo.api.AbstractTestApi;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRestControllerTest extends AbstractTestApi {


    @Test
    @Sql(value = "/script/UserControllerSQLScript/After.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Sql(value = "/script/UserControllerSQLScript/Before.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void checkGetProfile() throws Exception {
        mvc.perform(get("/api/account/profile").param("id","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Dmitry"))
                .andExpect(jsonPath("$.surname").value("Zinkin"))
                .andExpect(jsonPath("$.reputation").value(0));
    }

}
