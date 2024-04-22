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
public Receptionist getReceptionistByEmail(String email) {
    String query = "SELECT   Email ,UserPassword"
                 + "FROM tblReceptionest "
                 + "WHERE Email = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, email);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Receptionist receptionist = new Receptionist();
                //receptionist.setName(resultSet.getString("UserName"));
                //receptionist.setAddress(resultSet.getString("Address"));
               // receptionist.setGender(resultSet.getString("Gender"));
                //receptionist.setAge(resultSet.getInt("Age"));
                //receptionist.setSalary(resultSet.getDouble("Salary"));
               receptionist.setEmail(resultSet.getString("Email"));
                receptionist.setUserPassword(resultSet.getString("UserPassword"));

                return receptionist;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception or rethrow it as needed
    }
    return null;
}
public void createReceptionist(Receptionist receptionist) throws SQLException {
    String receptionistQuery = "INSERT INTO tblReceptionest (UserName, Gender, Address, Age, UserPassword, ShiftID, Salary, Email) " +
        "SELECT ?, ?, ?, ?, ?, s.ShiftID, ?, ? " +
        "FROM tblShift s " +
        "WHERE s.ShiftName = ?";

    try (PreparedStatement receptionistStatement = connection.prepareStatement(receptionistQuery)) {
        receptionistStatement.setString(1, receptionist.getName());
        receptionistStatement.setString(2, receptionist.getGender());
        receptionistStatement.setString(3, receptionist.getAddress());
        receptionistStatement.setInt(4, receptionist.getAge());
        receptionistStatement.setString(5, receptionist.getUserPassword());
        receptionistStatement.setDouble(6, receptionist.getSalary());
        receptionistStatement.setString(7, receptionist.getEmail());
        receptionistStatement.executeUpdate();
        System.out.println("Receptionist record created successfully.");
    }
}



//    public Receptionist[] getAllReceptionists() throws SQLException {
//        String query = "SELECT r.UserName, r.Gender, r.Address, r.Age, r.UserPassword, s.ShiftName, r.Salary, r.Email " +
//                "FROM tblReceptionist r " +
//                "JOIN tblShift s ON r.ShiftID = s.ShiftID";
//
//        try (PreparedStatement statement = connection.prepareStatement(query);
//             ResultSet resultSet = statement.executeQuery()) {
//
//            int initialCapacity = 10; // Initial capacity of the array
//            Receptionist[] receptionists = new Receptionist[initialCapacity];
//            int index = 0;
//
//            while (resultSet.next()) {
//                Receptionist receptionist = new Receptionist();
//                receptionist.setName(resultSet.getString("UserName"));
//                receptionist.setGender(resultSet.getString("Gender"));
//                receptionist.setAddress(resultSet.getString("Address"));
//                receptionist.setAge(resultSet.getInt("Age"));
//                receptionist.setUserPassword(resultSet.getString("UserPassword"));
//                receptionist.setShiftName(resultSet.getString("ShiftName"));
//                receptionist.setSalary(resultSet.getDouble("Salary"));
//                receptionist.setEmail(resultSet.getString("Email"));
//
//                if (index == receptionists.length) {
//                    // Resize the array if it's full
//                    Receptionist[] resizedReceptionists = new Receptionist[receptionists.length * 2];
//                    System.arraycopy(receptionists, 0, resizedReceptionists, 0, receptionists.length);
//                    receptionists = resizedReceptionists;
//                }
//
//                receptionists[index] = receptionist;
//                index++;
//            }
//
//            // Trim the array to the actual size
//            Receptionist[] finalReceptionists = new Receptionist[index];
//            System.arraycopy(receptionists, 0, finalReceptionists, 0, index);
//
//            return finalReceptionists;
//        }
//    }

   /* public Receptionist getReceptionistByEmail(String email) {
    String query = "SELECT UserName, Gender, Address, Age, UserPassword, Salary, Email "
                 + "FROM tblReceptionest "
                 + "WHERE Email = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, email);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Receptionist receptionist = new Receptionist();
                receptionist.setName(resultSet.getString("UserName"));
                receptionist.setAddress(resultSet.getString("Address"));
                receptionist.setGender(resultSet.getString("Gender"));
                receptionist.setAge(resultSet.getInt("Age"));
                receptionist.setSalary(resultSet.getDouble("Salary"));
                receptionist.setEmail(resultSet.getString("Email"));

                return receptionist;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception or rethrow it as needed
    }
    return null;
}*/



//    public void updateReceptionist(Receptionist receptionist) throws SQLException {
//        String query = "UPDATE tblReceptionist " +
//                "SET Address = ?, Gender = ?, Salary = ?, Email = ? " +
//                "WHERE UserName = ?";
//
//        try (PreparedStatement statement = connection.prepareStatement(query)) {
//            statement.setString(1, receptionist.getAddress());
//            statement.setString(2, receptionist.getGender());
//            statement.setDouble(3, receptionist.getSalary());
//            statement.setString(4, receptionist.getEmail());
//            statement.setString(5, receptionist.getName());
//            statement.executeUpdate();
//        }
//    }

    public void deleteReceptionist(String receptionistName) throws SQLException {
        String query = "DELETE FROM tblReceptionest WHERE UserName = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, receptionistName);
            statement.executeUpdate();
            System.out.println("Receptionist record deleted successfully.");
        }
    }
}