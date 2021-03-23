package ua.kpi.tef.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import ua.kpi.tef.context.Application;
import ua.kpi.tef.context.HibernateConfCommon;
import ua.kpi.tef.context.HibernateConfH2;
import ua.kpi.tef.context.HibernateConfPostgres;
import ua.kpi.tef.controller.DepartmentController;

//to start your controller
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        final ConfigurableEnvironment environment = context.getEnvironment();
        System.out.println("Active profile: " + environment.getProperty("spring.profiles.active"));
        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println(departmentController.getProfessorBySubject("Math"));
    }

}
