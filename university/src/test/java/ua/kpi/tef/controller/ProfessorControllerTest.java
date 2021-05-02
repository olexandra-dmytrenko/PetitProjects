package ua.kpi.tef.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import javax.transaction.Transactional;

import ua.kpi.tef.context.AppContext;
import ua.kpi.tef.model.Professor;

import static org.hamcrest.Matchers.containsString;import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.kpi.tef.TestFixtures.PROFESSOR;

@SpringBootTest(classes = AppContext.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
@Transactional
class ProfessorControllerTest {

    @Autowired
    private ProfessorController professorController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenAddProfessor_thenId() throws Exception {
        this.mockMvc.perform(post("/professor"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void whenGetByValidId_thenProfessor() throws Exception {
        final Professor expected = professorController.addProfessor(PROFESSOR);
        System.out.println(expected);
        this.mockMvc.perform(get("/professor", 1)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Name Surname")));
    }
}