package ua.kpi.tef.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.extern.slf4j.Slf4j;
import ua.kpi.tef.controller.DepartmentController;

@Slf4j
@SpringBootApplication(scanBasePackages = "ua.kpi.tef")
public class SpringBootRunner {
    public static void main(String[] args) {

        final ConfigurableApplicationContext context = SpringApplication.run(SpringBootRunner.class, args);

        final ConfigurableEnvironment environment = context.getEnvironment();
        log.debug("Active profile: " + environment.getProperty("spring.profiles.active"));

        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println(departmentController.getProfessorBySubject("Math"));
    }
}