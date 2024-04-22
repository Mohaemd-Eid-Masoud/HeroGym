package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoachDAL {
    private Connection connection;

    public CoachDAL(Connection connection) {
        this.connection = connection;
    }
   Course course=new Course();

    public CoachDAL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void createCoach(Coach coach) throws SQLException {
        String query = "INSERT INTO tblCoach (CoachName, Address, Gender, Mail, BirthDate, StartDate, EndDate, Experience, Age, PhoneNum, Shiftname) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getName());
            statement.setString(2, coach.getAddress());
            statement.setString(3, coach.getGender());
            statement.setString(4, coach.getMail());
            statement.setString(8, coach.getBirthDate());
            statement.setInt(9, coach.getAge());
            
            statement.executeUpdate();
        }
    }

   public Coach[] getAllCoach() throws SQLException {
    String query = "SELECT c.*, co.* " 
            + "FROM tblCoach c " 
            + "JOIN tblCourse co ON c.CoachID = co.CoachName";
    
    try (PreparedStatement statement = connection.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {
        
        int initialCapacity = 10; // Initial capacity of the array
        Coach[] coaches = new Coach[initialCapacity];
        int index = 0;
        
        while (resultSet.next()) {
            Coach coach = new Coach();
            coach.setName(resultSet.getString("CoachName"));
            coach.setAddress(resultSet.getString("Address"));
            coach.setGender(resultSet.getString("Gender"));
            coach.setMail(resultSet.getString("Mail"));
            coach.setBirthDate(resultSet.getString("BirthDate"));
            coach.setStartDate(resultSet.getString("StartDate"));
            coach.setEndDate(resultSet.getString("EndDate"));
            coach.setExperience(resultSet.getString("Experience"));
            coach.setAge(resultSet.getInt("Age"));
            coach.setShiftname(resultSet.getString("Shiftname"));
            String courseName = resultSet.getString("CourseName");
            coach.getCourse().setCourseName(courseName);
            
            if (index == coaches.length) {
                // Resize the array if it's full
                Coach[] resizedCoaches = new Coach[coaches.length * 2];
                System.arraycopy(coaches, 0, resizedCoaches, 0, coaches.length);
                coaches = resizedCoaches;
            }
            
            coaches[index] = coach;
            index++;
        }
        
        // Trim the array to the actual size
        Coach[] finalCoaches = new Coach[index];
        System.arraycopy(coaches, 0, finalCoaches, 0, index);
        
        return finalCoaches;
    }
}



    public Coach getCoachByName(String coachName) throws SQLException {
        String query ="SELECT c.*, co.* " +
               "FROM tblCoach c " +
               "JOIN tblCourse co ON c.CoachID = co.CoachID " +
               "WHERE c.CoachName = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coachName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                Coach coach = new Coach();
                coach.setName(resultSet.getString("CoachName"));
                coach.setAddress(resultSet.getString("Address"));
                coach.setGender(resultSet.getString("Gender"));
                coach.setMail(resultSet.getString("Mail"));
                coach.setBirthDate(resultSet.getString("BirthDate"));
                coach.setStartDate(resultSet.getString("StartDate"));
                coach.setEndDate(resultSet.getString("EndDate"));
                coach.setExperience(resultSet.getString("Experience"));
                coach.setAge(resultSet.getInt("Age"));
                coach.setShiftname(resultSet.getString("Shiftname"));
                
                // Set the course name on the coach's course object
                String courseName = resultSet.getString("CourseName");
                    coach.getCourse().setCourseName(courseName);
                
                    return coach;
                }
            }
        }
        return null;
    }

    public void updateCoach(Coach coach) throws SQLException {
        String query = "UPDATE tblCoach c " +
               "JOIN tblCourse co ON c.CoachID = co.CoachID " +
               "SET c.CoachName = ?, c.Address = ?, c.Gender = ?, c.Mail = ?, c.BirthDate = ?, c.StartDate = ?, " +
               "c.EndDate = ?, c.experience = ?, c.age = ?, c.PhoneNum = ?, c.CourseID = ? " +
               "WHERE c.CoachName = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getAddress());
            statement.setString(2, coach.getGender());
            statement.setString(3, coach.getMail());
            statement.setString(4, coach.getBirthDate());
            statement.setString(5, coach.getStartDate());
            statement.setString(6, coach.getEndDate());
            statement.setString(7, coach.getExperience());
            statement.setInt(8, coach.getAge());
            statement.setString(9, coach.getPhoneNum());
            //statement.setDouble(11, coach.getSalary());
            statement.setString(12, coach.getName());
            statement.executeUpdate();
        }
    }

    public void deleteCoach(String coachName) throws SQLException {
        String query = "DELETE FROM tblCoach WHERE CoachName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coachName);
            statement.executeUpdate();
        }
    }

}