package newpackage;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class MembershipBLL {
    private MembershipDAL membershipDAL;

    public MembershipBLL(MembershipDAL membershipDAL) {
        this.membershipDAL = membershipDAL;
    }

    public void createMembership(Membership membership) {
        try {
            membershipDAL.createMembership(membership);
            System.out.println("Membership created successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to create membership: " + e.getMessage());
        }
    }

    public List<Membership> getAllMemberships() {
        try {
            return membershipDAL.getAllMemberships();
        } catch (SQLException e) {
            System.out.println("Failed to retrieve memberships: " + e.getMessage());
            return null;
        }
    }

    public Membership getMembershipByDates(Date startDate, Date endDate) {
        try {
            return membershipDAL.getMembershipByDates(startDate, endDate);
        } catch (SQLException e) {
            System.out.println("Failed to retrieve membership: " + e.getMessage());
            return null;
        }
    }

    public void updateMembership(Membership membership) {
        try {
            membershipDAL.updateMembership(membership);
            System.out.println("Membership updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update membership: " + e.getMessage());
        }
    }

    public void deleteMembership(int membershipID) {
        try {
            membershipDAL.deleteMembership(membershipID);
            System.out.println("Membership deleted successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to delete membership: " + e.getMessage());
        }
    }
}
