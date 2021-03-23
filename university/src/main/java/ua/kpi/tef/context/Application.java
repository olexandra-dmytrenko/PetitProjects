package ua.kpi.tef.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"ua.kpi.tef.controller", "model", "ua.kpi.tef.service", "ua.kpi.tef.repository"})
@Import(HibernateConfCommon.class)
public class Application {


    // @Bean
    /*public DepartmentController departmentApi() {
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
    }*/

}