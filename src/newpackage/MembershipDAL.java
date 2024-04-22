package newpackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembershipDAL {
    private Connection connection;

    public MembershipDAL(Connection connection) {
        this.connection = connection;
    }

    public void createMembership(Membership membership) throws SQLException {
        String query = "INSERT INTO tblMembership (PaidAmount, StartDate, EndDate) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, membership.getPAidamount());
            statement.setDate(2, membership.getStartDate());
            statement.setDate(3, membership.getEndDate());
            statement.executeUpdate();
        }
    }

    public List<Membership> getAllMemberships() throws SQLException {
        String query = "SELECT * FROM tblMembership";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            List<Membership> memberships = new ArrayList<>();

            while (resultSet.next()) {
                int paidAmount = resultSet.getInt("PaidAmount");
                Date startDate = resultSet.getDate("StartDate");
                Date endDate = resultSet.getDate("EndDate");

                Membership membership = new Membership(paidAmount, startDate, endDate);
                memberships.add(membership);
            }

            return memberships;
        }
    }

    public Membership getMembershipByDates(Date startDate, Date endDate) throws SQLException {
        String query = "SELECT * FROM tblMembership WHERE StartDate = ? AND EndDate = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, (java.sql.Date) startDate);
            statement.setDate(2, (java.sql.Date) endDate);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int paidAmount = resultSet.getInt("PaidAmount");
                    Date membershipStartDate = resultSet.getDate("StartDate");
                    Date membershipEndDate = resultSet.getDate("EndDate");

                    Membership membership = new Membership(paidAmount, membershipStartDate, membershipEndDate);
                    return membership;
                }
            }
        }

        return null;
    }

    public void updateMembership(Membership membership) throws SQLException {
        String query = "UPDATE tblMembership SET PaidAmount = ? WHERE StartDate = ? AND EndDate = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, membership.getPAidamount());
            statement.setDate(2, membership.getStartDate());
            statement.setDate(3, membership.getEndDate());
            statement.executeUpdate();
        }
    }

    public void deleteMembership(Date startDate, Date endDate) throws SQLException {
        String query = "DELETE FROM tblMembership WHERE StartDate = ? AND EndDate = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, (java.sql.Date) startDate);
            statement.setDate(2, (java.sql.Date) endDate);
            statement.executeUpdate();
        }
    }
}
