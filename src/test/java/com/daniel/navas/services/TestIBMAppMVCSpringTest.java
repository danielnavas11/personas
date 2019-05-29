package com.daniel.navas.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TestIBMAppMVCSpringTest {
    @Autowired
    private MockMvc mvc;
    String testJsonSave = "{\"nombre\":\"nombreTestSave\",\"apellido\":\"apellidoTestSave\",\"sexo\":\"M\",\"edad\":\"40\"}";
    String testJsonPut = "{\"nombre\":\"nombreTestPut\",\"apellido\":\"apellidoTestPut\",\"sexo\":\"F\",\"edad\":\"44\"}";

    @Test
    public void personasAll() throws Exception {
        mvc.perform(get("/personas"))
                .andExpect(status().isOk());
    }

    @Test
    public void savePersona() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/personas")
                .accept(MediaType.APPLICATION_JSON).content(testJsonSave)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    @Test
    public void deletePersona() throws Exception {
        savePersona();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/personas/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder)
                .andExpect(status().isOk());

    }

    @Test
    public void putPersona() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/personas/1")
                .accept(MediaType.APPLICATION_JSON).content(testJsonPut)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(status().isOk());

    }
    @Test
    public void putPersona2() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/personas/2")
                .accept(MediaType.APPLICATION_JSON).content(testJsonPut)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder).andExpect(status().isOk());

    }

}
