package newpackage;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReceptionistDAL {
    private Connection connection;

    public ReceptionistDAL(Connection connection) {
        this.connection = connection;
    }
    
    public ReceptionistDAL() {
        this.connection = Tools.dbConnection();
    }

    public void createReceptionist(Receptionist receptionist) throws SQLException {
        String query = "INSERT INTO tblReceptionest (UserName, Gender, Address, Age, UserPassword, salary, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, receptionist.getName());
            statement.setString(2, receptionist.getGender());
            statement.setString(3, receptionist.getAddress());
            statement.setInt(4, receptionist.getAge());
            statement.setString(5, receptionist.getUserPassword());
            statement.setDouble(6, receptionist.getSalary());
            statement.setString(7, receptionist.getEmail());
            statement.executeUpdate();
            System.out.println("Receptionist record created successfully.");
        }
    }

    public Receptionist[] getAllReceptionists() throws SQLException {
        String query = "SELECT * FROM tblReceptionest";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            int initialCapacity = 10;
            Receptionist[] receptionists = new Receptionist[initialCapacity];
            int index = 0;

            while (resultSet.next()) {
                Receptionist receptionist = new Receptionist();
                receptionist.setName(resultSet.getString("UserName"));
                receptionist.setGender(resultSet.getString("Gender"));
                receptionist.setAddress(resultSet.getString("Address"));
                receptionist.setAge(resultSet.getInt("Age"));
                receptionist.setUserPassword(resultSet.getString("UserPassword"));
                
                String salaryStr = resultSet.getString("salary");
                if (salaryStr != null && !salaryStr.isEmpty()) {
                    try { receptionist.setSalary(Double.parseDouble(salaryStr)); } catch (NumberFormatException e) { }
                }
                
                receptionist.setEmail(resultSet.getString("Email"));

                if (index == receptionists.length) {
                    Receptionist[] resizedReceptionists = new Receptionist[receptionists.length * 2];
                    System.arraycopy(receptionists, 0, resizedReceptionists, 0, receptionists.length);
                    receptionists = resizedReceptionists;
                }

                receptionists[index] = receptionist;
                index++;
            }

            Receptionist[] finalReceptionists = new Receptionist[index];
            System.arraycopy(receptionists, 0, finalReceptionists, 0, index);

            return finalReceptionists;
        }
    }

    public Receptionist getReceptionistByEmail(String email) {
        String query = "SELECT * FROM tblReceptionest WHERE Email = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Receptionist receptionist = new Receptionist();
                    receptionist.setName(resultSet.getString("UserName"));
                    receptionist.setAddress(resultSet.getString("Address"));
                    receptionist.setGender(resultSet.getString("Gender"));
                    receptionist.setAge(resultSet.getInt("Age"));
                    
                    String salaryStr = resultSet.getString("salary");
                    if (salaryStr != null && !salaryStr.isEmpty()) {
                        try { receptionist.setSalary(Double.parseDouble(salaryStr)); } catch (NumberFormatException e) { }
                    }
                    
                    receptionist.setEmail(resultSet.getString("Email"));
                    receptionist.setUserPassword(resultSet.getString("UserPassword"));

                    return receptionist;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateReceptionist(Receptionist receptionist) throws SQLException {
        String query = "UPDATE tblReceptionest SET Address = ?, Gender = ?, salary = ?, Email = ?, Age = ?, UserPassword = ? WHERE UserName = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, receptionist.getAddress());
            statement.setString(2, receptionist.getGender());
            statement.setDouble(3, receptionist.getSalary());
            statement.setString(4, receptionist.getEmail());
            statement.setInt(5, receptionist.getAge());
            statement.setString(6, receptionist.getUserPassword());
            statement.setString(7, receptionist.getName());
            statement.executeUpdate();
        }
    }

    public void deleteReceptionist(String receptionistName) throws SQLException {
        String query = "DELETE FROM tblReceptionest WHERE UserName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, receptionistName);
            statement.executeUpdate();
            System.out.println("Receptionist record deleted successfully.");
        }
    }
}