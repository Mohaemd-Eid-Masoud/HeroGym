package newpackage;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class MemberDAL {


    
    public MemberDAL() {
        Tools.dbConnection();
    }

    public void createMember(Member member) throws SQLException {
        String memberQuery = "INSERT INTO tblMember (MemberName, Gender, height,Level, weight, Age, PhoneNum, CoachId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement memberStatement = Tools.dbConnection().prepareStatement(memberQuery)) {

            // Insert the member into TBLMEMBER table
            memberStatement.setString(1, member.getMemberName());
            memberStatement.setString(2, (member.getGender()));
            memberStatement.setDouble(3, member.getHeight());
            memberStatement.setString(4, member.getLevel());
            memberStatement.setDouble(5, member.getWeight());
            memberStatement.setInt(6, member.getAge());
            memberStatement.setString(7, member.getPhoneNum());
            memberStatement.setInt(8, member.getCoachID());

            memberStatement.executeUpdate();

            // Retrieve the generated member ID
            int generatedMemberId = -1;
            try (ResultSet generatedKeys = memberStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedMemberId = generatedKeys.getInt(1);
                }
            }

            // Do something with the generated member ID
            System.out.println("Generated Member ID: " + generatedMemberId);
        }
    }


    /* public Member[] getAllMembers() throws SQLException {
    String query = "SELECT tblMember.*, tblCourse.CourseName, tblCoach.CoachName " +
                   "FROM tblMember " +
                   "INNER JOIN (tblCourse INNER JOIN tblCoach ON tblCourse.CourseID = tblCoach.CourseID) " +
                   "ON tblMember.CoachId = tblCoach.CoachID";

    try (PreparedStatement statement = Tools.dbConnection().prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {

        int initialCapacity = 10; // Initial capacity of the array
        Member[] members = new Member[initialCapacity];
        int index = 0;

        while (resultSet.next()) {
            Member member = new Member();

            member.setMemberName(resultSet.getString("MemberName"));
            member.setBirthDate(resultSet.getDate("BirthDate").toLocalDate());
            member.setGender(resultSet.getString("Gender"));
            member.setHeight(resultSet.getDouble("Height"));
            member.setWeight(resultSet.getDouble("Weight"));
            member.setAge(resultSet.getInt("Age"));
            member.setPhoneNum(resultSet.getString("PhoneNum"));

            // Create Coach object and set coach name
            Coach coach = new Coach();
            coach.setCoachName(resultSet.getString("CoachName"));

            // Set coach for the member
            member.setCoach(coach);

            // Create Course object and set course name
            Course course = new Course();
            course.setCourseName(resultSet.getString("CourseName"));

            // Set course for the member
            member.setCourse(course);

            if (index == members.length) {
                // Resize the array if it's full
                Member[] resizedMembers = new Member[members.length * 2];
                System.arraycopy(members, 0, resizedMembers, 0, members.length);
                members = resizedMembers;
            }

            members[index] = member;
            index++;
        }

        // Trim the array to the actual size
        Member[] finalMembers = new Member[index];
        System.arraycopy(members, 0, finalMembers, 0, index);

        return finalMembers;
    }
}*/

     
    public Member getMemberByName(String memberName) throws SQLException {
    String query = "SELECT tblMember.MemberName, tblMember.Age, tblMember.Level\n" +
"FROM tblMember;";

    try (PreparedStatement statement = Tools.dbConnection().prepareStatement(query)) {
        statement.setString(1, memberName);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                Member member = new Member();
                member.setMemberName(resultSet.getString("MemberName"));
                 
                member.setAge(resultSet.getInt("Age"));
                member.setPhoneNum(resultSet.getString("Level"));
               

                return member;
            }
        }
    }
    return null;
}


    public void updateMember(Member member) throws SQLException {
    String updateQuery = "UPDATE tblMember " +
            "SET MemberName = ?, Age = ?, Height = ?, Level = ? " +
            "WHERE MemberName = ?";

    try (PreparedStatement updateStatement = Tools.dbConnection().prepareStatement(updateQuery)) {
        updateStatement.setString(1, member.getMemberName());
        updateStatement.setInt(2, member.getAge());
        updateStatement.setString(3, member.getLevel());

        updateStatement.executeUpdate();
    }
}



    public void deleteMember(String memberName) throws SQLException {
        String deleteQuery = "DELETE FROM tblMember WHERE MemberName = ?";

        try (PreparedStatement deleteStatement = Tools.dbConnection().prepareStatement(deleteQuery)) {
            deleteStatement.setString(1, memberName);//fix error
            deleteStatement.executeUpdate();
        }
    }

    
}
