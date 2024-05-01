package hybernate.service.impl;

import hybernate.dao.CourseDao;
import hybernate.dao.impl.CourseDaoImpl;
import hybernate.service.CourseService;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    public int countStudentsFromCourse(Long courseId) {
        return courseDao.countStudentsFromCourse(courseId);
    }
}
