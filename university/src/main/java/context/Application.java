package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.SubjectRepository;
import university.controller.DepartmentController;
import university.service.DepartmentService;
import university.service.DepartmentServiceImpl;
import university.service.SubjectService;
import university.service.SubjectServiceImpl;

@Configuration
public class Application {

    @Bean
    public DepartmentController departmentApi() {
        return new DepartmentController(departmentService());
    }

    @Bean
    public DepartmentService departmentService() {
        final DepartmentServiceImpl departmentService = new DepartmentServiceImpl();
        return departmentService.setSubjectService(subjectService());
    }

    @Bean
    public SubjectService subjectService() {
        return new SubjectServiceImpl(subjectRepository());
    }

    @Bean
    protected SubjectRepository subjectRepository() {
        return new SubjectRepository();
    }

}
