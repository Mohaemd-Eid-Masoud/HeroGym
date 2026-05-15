package newpackage;


import java.sql.SQLException;
import java.util.List;

public class CourseBLL {
    private CourseDAL courseDAL;

    public CourseBLL(CourseDAL courseDAL) {
        this.courseDAL = courseDAL;
    }

    public void createCourse(Course course) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            courseDAL.createCourse(course);
        } catch (SQLException e) {
            throw new BusinessException("Failed to create course.", e);
        }
    }

    public  Course [] CourseBLLrses() throws BusinessException {
        try {
            return courseDAL.getAllCourses();
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve courses.", e);
        }
    }

    public Course getCourseByName(String courseName) throws BusinessException {
        try {
            return courseDAL.getCourseByName(courseName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve course by name.", e);
        }
    }

    public void updateCourse(Course course) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            courseDAL.updateCourse(course);
        } catch (SQLException e) {
            throw new BusinessException("Failed to update course.", e);
        }
    }

    public void deleteCourse(String courseName) throws BusinessException {
        try {
            courseDAL.deleteCourse(courseName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to delete course.", e);
        }
    }
}