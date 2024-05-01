package hybernate;

import hybernate.config.HibernateConfig;
import hybernate.service.CourseService;
import hybernate.service.impl.CourseServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        System.out.println(courseService.countStudentsFromCourse(1L));
    }
}
