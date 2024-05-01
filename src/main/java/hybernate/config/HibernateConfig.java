package hybernate.config;

import hybernate.entity.*;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "1234");
        properties.setProperty(Environment.HBM2DDL_AUTO, "create");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        return properties;

    }

    public static EntityManagerFactory entityManagerFactory() {
        Configuration configuration = new Configuration();
        configuration.addProperties(properties());
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Mentor.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Task.class);
        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);

    }

    public static SessionFactory sessionFactory() {
        return entityManagerFactory().unwrap(SessionFactory.class);
    }
}
