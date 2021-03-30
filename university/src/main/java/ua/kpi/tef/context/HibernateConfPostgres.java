package ua.kpi.tef.context;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@Profile("postgres")
public class HibernateConfPostgres {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }

    /*
        create – Hibernate first drops existing tables, then creates new tables
        update – the object model created based on the mappings (annotations or XML) is compared with the existing schema, and then Hibernate updates the schema according to the diff. It never deletes the existing tables or columns even if they are no more required by the application
        create-drop – similar to create, with the addition that Hibernate will drop the database after all operations are completed. Typically used for unit testing
        validate – Hibernate only validates whether the tables and columns exist, otherwise it throws an exception
        none – this value effectively turns off the DDL generation
         */
   // @Bean
    public Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.hbm2ddl.auto", "create-drop"); //update, validate, create, create-drop create-drop
        hibernateProperties.setProperty(
                "hibernate.dialect",
                "org.hibernate.dialect.PostgreSQLDialect"
        );
        hibernateProperties.setProperty("hibernate.format_sql", "true");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        return hibernateProperties;
    }

}
