package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class MembershipDAL {
    private Connection connection;

    public MembershipDAL(Connection connection) {
        this.connection = connection;
    }
    
    public MembershipDAL() {
        this.connection = Tools.dbConnection();
    }

    public void createMembership(Membership membership) throws SQLException {
        String query = "INSERT INTO tblMemberShip (MemberID, PAidAmount, StartDate, EndDate) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, membership.getMemberID());
            statement.setInt(2, membership.getPAidamount());
            statement.setDate(3, membership.getStartDate());
            statement.setDate(4, membership.getEndDate());
            statement.executeUpdate();
        }
    }

    public List<Membership> getAllMemberships() throws SQLException {
        String query = "SELECT * FROM tblMemberShip";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            List<Membership> memberships = new ArrayList<>();

            while (resultSet.next()) {
                Membership membership = new Membership();
                membership.setMembershipID(resultSet.getInt("MemberShipID"));
                membership.setMemberID(resultSet.getInt("MemberID"));
                membership.setPAidamount(resultSet.getInt("PAidAmount"));
                membership.setStartDate(resultSet.getDate("StartDate"));
                membership.setEndDate(resultSet.getDate("EndDate"));

                memberships.add(membership);
            }

            return memberships;
        }
    }

    public Membership getMembershipByDates(Date startDate, Date endDate) throws SQLException {
        String query = "SELECT * FROM tblMemberShip WHERE StartDate = ? AND EndDate = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, startDate);
            statement.setDate(2, endDate);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Membership membership = new Membership();
                    membership.setMembershipID(resultSet.getInt("MemberShipID"));
                    membership.setMemberID(resultSet.getInt("MemberID"));
                    membership.setPAidamount(resultSet.getInt("PAidAmount"));
                    membership.setStartDate(resultSet.getDate("StartDate"));
                    membership.setEndDate(resultSet.getDate("EndDate"));
                    return membership;
                }
            }
        }

        return null;
    }

    public void updateMembership(Membership membership) throws SQLException {
        String query = "UPDATE tblMemberShip SET MemberID = ?, PAidAmount = ?, StartDate = ?, EndDate = ? WHERE MemberShipID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, membership.getMemberID());
            statement.setInt(2, membership.getPAidamount());
            statement.setDate(3, membership.getStartDate());
            statement.setDate(4, membership.getEndDate());
            statement.setInt(5, membership.getMembershipID());
            statement.executeUpdate();
        }
    }

    public void deleteMembership(int membershipID) throws SQLException {
        String query = "DELETE FROM tblMemberShip WHERE MemberShipID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, membershipID);
            statement.executeUpdate();
        }
    }
}
