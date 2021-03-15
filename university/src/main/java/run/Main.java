package run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import context.Application;
import university.controller.DepartmentController;

//to start your controller
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println(departmentController.getProfessorBySubject("Math"));
    }

}
