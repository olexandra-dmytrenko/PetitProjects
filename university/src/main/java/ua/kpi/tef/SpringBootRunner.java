package ua.kpi.tef;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackages = "ua.kpi.tef")
public class SpringBootRunner extends SpringBootServletInitializer {
    public static void main(String[] args) {
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(SpringBootRunner.class, args));

//        final ConfigurableApplicationContext context = SpringApplication.run(SpringBootRunner.class, args);
/*
        final ConfigurableEnvironment environment = context.getEnvironment();
        log.debug("Active profile: " + environment.getProperty("spring.profiles.active"));

        final DepartmentController departmentController = context.getBean(DepartmentController.class);

        System.out.println(departmentController.getProfessorBySubject("Math"));
    */
    }

}