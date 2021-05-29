package com.database.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class TestManagerOracleController {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    void getConnection() throws Exception {
        String connection = "{\"user\":\"digital\",\"password\":\"password\",\"databaseName\":\"ORCLCDB\",\"serverName\":\"localhost\",\"portNumber\":1521}";
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/manager/oracle")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(connection)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }
	
}
