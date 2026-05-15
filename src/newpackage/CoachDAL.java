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

    public CoachDAL() {
        this.connection = Tools.dbConnection();
    }

    public void createCoach(Coach coach) throws SQLException {
        String query = "INSERT INTO tblCoach (CoachName, Address, Gender, Mail, BirthDate, StartDate, EndDate, experience, age, PhoneNum) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getName());
            statement.setString(2, coach.getAddress());
            statement.setString(3, coach.getGender());
            statement.setString(4, coach.getMail());
            
            // Handle dates
            if (coach.getBirthDate() != null && !coach.getBirthDate().isEmpty()) {
                try { statement.setDate(5, java.sql.Date.valueOf(coach.getBirthDate())); } catch (Exception e) { statement.setNull(5, java.sql.Types.DATE); }
            } else { statement.setNull(5, java.sql.Types.DATE); }
            
            if (coach.getStartDate() != null && !coach.getStartDate().isEmpty()) {
                try { statement.setDate(6, java.sql.Date.valueOf(coach.getStartDate())); } catch (Exception e) { statement.setNull(6, java.sql.Types.DATE); }
            } else { statement.setNull(6, java.sql.Types.DATE); }
            
            if (coach.getEndDate() != null && !coach.getEndDate().isEmpty()) {
                try { statement.setDate(7, java.sql.Date.valueOf(coach.getEndDate())); } catch (Exception e) { statement.setNull(7, java.sql.Types.DATE); }
            } else { statement.setNull(7, java.sql.Types.DATE); }
            
            statement.setString(8, coach.getExperience());
            statement.setInt(9, coach.getAge());
            statement.setString(10, coach.getPhoneNum());
            statement.executeUpdate();
        }
    }

    public Coach[] getAllCoach() throws SQLException {
        String query = "SELECT * FROM tblCoach";
        
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
                
                if (resultSet.getDate("BirthDate") != null) coach.setBirthDate(resultSet.getDate("BirthDate").toString());
                if (resultSet.getDate("StartDate") != null) coach.setStartDate(resultSet.getDate("StartDate").toString());
                if (resultSet.getDate("EndDate") != null) coach.setEndDate(resultSet.getDate("EndDate").toString());
                
                coach.setExperience(resultSet.getString("experience"));
                coach.setAge(resultSet.getInt("age"));
                coach.setPhoneNum(resultSet.getString("PhoneNum"));
                
                if (index == coaches.length) {
                    Coach[] resizedCoaches = new Coach[coaches.length * 2];
                    System.arraycopy(coaches, 0, resizedCoaches, 0, coaches.length);
                    coaches = resizedCoaches;
                }
                
                coaches[index] = coach;
                index++;
            }
            
            Coach[] finalCoaches = new Coach[index];
            System.arraycopy(coaches, 0, finalCoaches, 0, index);
            
            return finalCoaches;
        }
    }

    public Coach getCoachByName(String coachName) throws SQLException {
        String query = "SELECT * FROM tblCoach WHERE CoachName = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coachName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Coach coach = new Coach();
                    coach.setName(resultSet.getString("CoachName"));
                    coach.setAddress(resultSet.getString("Address"));
                    coach.setGender(resultSet.getString("Gender"));
                    coach.setMail(resultSet.getString("Mail"));
                    
                    if (resultSet.getDate("BirthDate") != null) coach.setBirthDate(resultSet.getDate("BirthDate").toString());
                    if (resultSet.getDate("StartDate") != null) coach.setStartDate(resultSet.getDate("StartDate").toString());
                    if (resultSet.getDate("EndDate") != null) coach.setEndDate(resultSet.getDate("EndDate").toString());
                    
                    coach.setExperience(resultSet.getString("experience"));
                    coach.setAge(resultSet.getInt("age"));
                    coach.setPhoneNum(resultSet.getString("PhoneNum"));
                    
                    return coach;
                }
            }
        }
        return null;
    }

    public void updateCoach(Coach coach) throws SQLException {
        String query = "UPDATE tblCoach SET Address = ?, Gender = ?, Mail = ?, BirthDate = ?, StartDate = ?, EndDate = ?, experience = ?, age = ?, PhoneNum = ? WHERE CoachName = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, coach.getAddress());
            statement.setString(2, coach.getGender());
            statement.setString(3, coach.getMail());
            
            if (coach.getBirthDate() != null && !coach.getBirthDate().isEmpty()) {
                try { statement.setDate(4, java.sql.Date.valueOf(coach.getBirthDate())); } catch (Exception e) { statement.setNull(4, java.sql.Types.DATE); }
            } else { statement.setNull(4, java.sql.Types.DATE); }
            
            if (coach.getStartDate() != null && !coach.getStartDate().isEmpty()) {
                try { statement.setDate(5, java.sql.Date.valueOf(coach.getStartDate())); } catch (Exception e) { statement.setNull(5, java.sql.Types.DATE); }
            } else { statement.setNull(5, java.sql.Types.DATE); }
            
            if (coach.getEndDate() != null && !coach.getEndDate().isEmpty()) {
                try { statement.setDate(6, java.sql.Date.valueOf(coach.getEndDate())); } catch (Exception e) { statement.setNull(6, java.sql.Types.DATE); }
            } else { statement.setNull(6, java.sql.Types.DATE); }
            
            statement.setString(7, coach.getExperience());
            statement.setInt(8, coach.getAge());
            statement.setString(9, coach.getPhoneNum());
            statement.setString(10, coach.getName());
            
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