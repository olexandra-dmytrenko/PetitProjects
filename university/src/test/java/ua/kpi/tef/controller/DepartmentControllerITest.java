package ua.kpi.tef.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import ua.kpi.tef.context.AppContext;
import ua.kpi.tef.dto.ProfResponseProfTransfer;
import ua.kpi.tef.dto.ProfessorResponse;
import ua.kpi.tef.exception.ProfessorNotFountException;
import ua.kpi.tef.exception.SubjectNotFountException;
import ua.kpi.tef.model.Professor;
import ua.kpi.tef.model.Subject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ua.kpi.tef.TestFixtures.PROFESSOR;
import static ua.kpi.tef.TestFixtures.SUBJ_NAME;

@SpringBootTest(classes = {AppContext.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
class DepartmentControllerITest {

    @Autowired
    private DepartmentController departmentService;
    @Autowired
    private ProfessorController professorController;
    @Autowired
    private SubjectController subjectController;

    @Test
    void whenFindProfByExistingSubject_ProfFound() {
        // GIVEN
        final ProfessorResponse createdProfResp = professorController.addProfessor(PROFESSOR).getBody();
        final Professor expectedProf = ProfResponseProfTransfer.from(createdProfResp);
        subjectController.addSubject(new Subject(SUBJ_NAME, expectedProf));

        // WHEN
        final Professor actual = departmentService.getProfessorBySubject(SUBJ_NAME);

        //THEN
        assertEquals(expectedProf, actual);
        //Tear down: delete prof and subject by actual.getId or
        // put @Transactional annotation to make data rollback by default
    }

    @Test
    void whenFindProfByNonExistingSubject_ThrowSubjectNotFoundEx() {
        // GIVEN make sure not to use existing data in the DB

        //WHEN THEN
        assertThrows(SubjectNotFountException.class,
                () -> departmentService.getProfessorBySubject(SUBJ_NAME + 1));
    }

    @Test
    void whenFindNonExistingProfByExistingSubject_ThrowSubjectNotFoundEx() {
        // GIVEN
        subjectController.addSubject(new Subject(SUBJ_NAME, null));
        //WHEN THEN
        assertThrows(ProfessorNotFountException.class,
                () -> departmentService.getProfessorBySubject(SUBJ_NAME));
    }
}