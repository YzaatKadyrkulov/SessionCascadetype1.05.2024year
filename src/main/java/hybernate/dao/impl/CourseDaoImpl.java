package hybernate.dao.impl;

import hybernate.config.HibernateConfig;
import hybernate.dao.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.entityManagerFactory();

    @Override
    public int countStudentsFromCourse(Long courseId) {
        int count = 0;
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            count = entityManager.createQuery("select count(s.id) from Student s " +
                            "inner join s.courses sc where sc.id = : courseId", Integer.class).
                    setParameter("courseId", courseId).getSingleResult();
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }
}
