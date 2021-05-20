package ua.kpi.tef.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;

//TODO: 1) SpringBoot in a separate class
//TODO: 2) Fix Hibernate with lazy
//TODO: 3) Make tests
@Configuration
@Slf4j
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"ua.kpi.tef.controller", "ua.kpi.tef.service", "ua.kpi.tef.repository", "ua.kpi.tef.ui"})
@Import(HibernateConfCommon.class)
public class AppContext {

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