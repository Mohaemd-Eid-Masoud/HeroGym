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

    public void createCourse(Course course) throws SQLException {
    String query = "INSERT INTO tblCourse (CourseName, Plan) VALUES (?, ?, ?)";

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

        int initialCapacity = 10; // Initial capacity of the array
        Course[] courses = new Course[initialCapacity];
        int index = 0;

        while (resultSet.next()) {
            Course course = new Course();
            course.setCourseName(resultSet.getString("CourseName"));
            course.setPlan(resultSet.getString("Plan"));

            if (index == courses.length) {
                // Resize the array if it's full
                Course[] resizedCourses = new Course[courses.length * 2];
                System.arraycopy(courses, 0, resizedCourses, 0, courses.length);
                courses = resizedCourses;
            }

            courses[index] = course;
            index++;
        }

        // Trim the array to the actual size
        Course[] finalCourses = new Course[index];
        System.arraycopy(courses, 0, finalCourses, 0, index);

        return finalCourses;
    }
}


    public Course getCourseById(int courseId) throws SQLException {
        String query = "SELECT * FROM Courses WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, courseId);
        ResultSet resultSet = statement.executeQuery();
        Course course = null;
        if (resultSet.next()) {
            course = new Course();
            course.setCourseName(resultSet.getString("Course_Name"));
        }
        resultSet.close();
        statement.close();
        return course;
    }

    public void updateCourse(Course course) throws SQLException {
        String query = "UPDATE Courses SET Course_Name = ? WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, course.getCourseName());
        statement.executeUpdate();
        statement.close();
    }

    public void deleteCourse(int courseId) throws SQLException {
        String query = "DELETE FROM Courses WHERE ID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, courseId);
        statement.executeUpdate();
        statement.close();
    }
}