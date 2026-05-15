package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAL {
    private Connection connection;

    public CourseDAL(Connection connection) {
        this.connection = connection;
    }

    public CourseDAL() {
        this.connection = Tools.dbConnection();
    }

    public void createCourse(Course course) throws SQLException {
        String query = "INSERT INTO tblCourse (CourseName, Plan) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getCourseName());
            statement.setString(2, course.getPlan());
            statement.executeUpdate();
        }
    }

    public Course[] getAllCourses() throws SQLException {
        String query = "SELECT * FROM tblCourse";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            int initialCapacity = 10;
            Course[] courses = new Course[initialCapacity];
            int index = 0;

            while (resultSet.next()) {
                Course course = new Course();
                course.setCourseName(resultSet.getString("CourseName"));
                course.setPlan(resultSet.getString("Plan"));

                if (index == courses.length) {
                    Course[] resizedCourses = new Course[courses.length * 2];
                    System.arraycopy(courses, 0, resizedCourses, 0, courses.length);
                    courses = resizedCourses;
                }

                courses[index] = course;
                index++;
            }

            Course[] finalCourses = new Course[index];
            System.arraycopy(courses, 0, finalCourses, 0, index);

            return finalCourses;
        }
    }

    public Course getCourseByName(String courseName) throws SQLException {
        String query = "SELECT * FROM tblCourse WHERE CourseName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseName);
            try (ResultSet resultSet = statement.executeQuery()) {
                Course course = null;
                if (resultSet.next()) {
                    course = new Course();
                    course.setCourseName(resultSet.getString("CourseName"));
                    course.setPlan(resultSet.getString("Plan"));
                }
                return course;
            }
        }
    }

    public void updateCourse(Course course) throws SQLException {
        String query = "UPDATE tblCourse SET Plan = ? WHERE CourseName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getPlan());
            statement.setString(2, course.getCourseName());
            statement.executeUpdate();
        }
    }

    public void deleteCourse(String courseName) throws SQLException {
        String query = "DELETE FROM tblCourse WHERE CourseName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, courseName);
            statement.executeUpdate();
        }
    }
}