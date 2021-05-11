package ua.kpi.tef.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import ua.kpi.tef.context.AppContext;
import ua.kpi.tef.dto.ProfessorResponse;

import static org.hamcrest.Matchers.containsString;
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
        final ProfessorResponse expected = professorController.addProfessor(PROFESSOR).getBody();
        System.out.println("Output:" + expected);
        this.mockMvc.perform(get("/professor/" + expected.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expected.getName())));
    }
}