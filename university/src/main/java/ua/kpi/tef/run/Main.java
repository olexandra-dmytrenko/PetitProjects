package ua.kpi.tef.run;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.extern.slf4j.Slf4j;
import ua.kpi.tef.context.AppContext;
import ua.kpi.tef.controller.DepartmentController;

//to start your controller
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Start Application");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));

        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println(departmentController.getProfessorBySubject("Math"));
    }
}