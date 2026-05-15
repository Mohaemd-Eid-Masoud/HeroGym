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
        String memberQuery = "INSERT INTO tblMember (MemberName, Gender, height, Level, weight, Age, PhoneNum, CoachId, BirthDate, CoachName, CourseName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement memberStatement = Tools.dbConnection().prepareStatement(memberQuery, java.sql.Statement.RETURN_GENERATED_KEYS)) {
            memberStatement.setString(1, member.getMemberName());
            memberStatement.setString(2, member.getGender());
            if (member.getHeight() != null) memberStatement.setDouble(3, member.getHeight()); else memberStatement.setNull(3, java.sql.Types.DOUBLE);
            memberStatement.setString(4, member.getLevel());
            if (member.getWeight() != null) memberStatement.setDouble(5, member.getWeight()); else memberStatement.setNull(5, java.sql.Types.DOUBLE);
            memberStatement.setInt(6, member.getAge());
            memberStatement.setString(7, member.getPhoneNum());
            if (member.getCoachID() > 0) memberStatement.setInt(8, member.getCoachID()); else memberStatement.setNull(8, java.sql.Types.INTEGER);
            if (member.getBirthDate() != null) memberStatement.setDate(9, java.sql.Date.valueOf(member.getBirthDate())); else memberStatement.setNull(9, java.sql.Types.DATE);
            memberStatement.setString(10, member.getCoachName());
            memberStatement.setString(11, member.getCourseName());

            memberStatement.executeUpdate();

            int generatedMemberId = -1;
            try (ResultSet generatedKeys = memberStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    generatedMemberId = generatedKeys.getInt(1);
                }
            }
            System.out.println("Generated Member ID: " + generatedMemberId);
        }
    }


    public Member[] getAllMembers() throws SQLException {
        String query = "SELECT * FROM tblMember";

        try (PreparedStatement statement = Tools.dbConnection().prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            int initialCapacity = 10;
            Member[] members = new Member[initialCapacity];
            int index = 0;

            while (resultSet.next()) {
                Member member = new Member();
                member.setMemberID(resultSet.getInt("MemberID"));
                member.setMemberName(resultSet.getString("MemberName"));
                Date bd = resultSet.getDate("BirthDate");
                if (bd != null) member.setBirthDate(bd.toLocalDate());
                member.setGender(resultSet.getString("Gender"));
                member.setLevel(resultSet.getString("Level"));
                member.setHeight(resultSet.getDouble("height"));
                member.setWeight(resultSet.getDouble("weight"));
                member.setAge(resultSet.getInt("Age"));
                member.setPhoneNum(resultSet.getString("PhoneNum"));
                member.setCoachID(resultSet.getInt("CoachId"));
                
                Coach coach = new Coach();
                coach.setName(resultSet.getString("CoachName"));
                member.setCoach(coach);
                
                Course course = new Course();
                course.setCourseName(resultSet.getString("CourseName"));
                member.setCourse(course);

                if (index == members.length) {
                    Member[] resizedMembers = new Member[members.length * 2];
                    System.arraycopy(members, 0, resizedMembers, 0, members.length);
                    members = resizedMembers;
                }

                members[index] = member;
                index++;
            }

            Member[] finalMembers = new Member[index];
            System.arraycopy(members, 0, finalMembers, 0, index);

            return finalMembers;
        }
    }

    public Member getMemberByName(String memberName) throws SQLException {
        String query = "SELECT * FROM tblMember WHERE MemberName = ?";

        try (PreparedStatement statement = Tools.dbConnection().prepareStatement(query)) {
            statement.setString(1, memberName);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Member member = new Member();
                    member.setMemberID(resultSet.getInt("MemberID"));
                    member.setMemberName(resultSet.getString("MemberName"));
                    Date bd = resultSet.getDate("BirthDate");
                    if (bd != null) member.setBirthDate(bd.toLocalDate());
                    member.setGender(resultSet.getString("Gender"));
                    member.setLevel(resultSet.getString("Level"));
                    member.setHeight(resultSet.getDouble("height"));
                    member.setWeight(resultSet.getDouble("weight"));
                    member.setAge(resultSet.getInt("Age"));
                    member.setPhoneNum(resultSet.getString("PhoneNum"));
                    member.setCoachID(resultSet.getInt("CoachId"));
                    
                    Coach coach = new Coach();
                    coach.setName(resultSet.getString("CoachName"));
                    member.setCoach(coach);
                    
                    Course course = new Course();
                    course.setCourseName(resultSet.getString("CourseName"));
                    member.setCourse(course);

                    return member;
                }
            }
        }
        return null;
    }

    public void updateMember(Member member) throws SQLException {
        String updateQuery = "UPDATE tblMember SET Gender = ?, height = ?, Level = ?, weight = ?, Age = ?, PhoneNum = ?, CoachId = ?, BirthDate = ?, CoachName = ?, CourseName = ? WHERE MemberName = ?";

        try (PreparedStatement updateStatement = Tools.dbConnection().prepareStatement(updateQuery)) {
            updateStatement.setString(1, member.getGender());
            if (member.getHeight() != null) updateStatement.setDouble(2, member.getHeight()); else updateStatement.setNull(2, java.sql.Types.DOUBLE);
            updateStatement.setString(3, member.getLevel());
            if (member.getWeight() != null) updateStatement.setDouble(4, member.getWeight()); else updateStatement.setNull(4, java.sql.Types.DOUBLE);
            updateStatement.setInt(5, member.getAge());
            updateStatement.setString(6, member.getPhoneNum());
            if (member.getCoachID() > 0) updateStatement.setInt(7, member.getCoachID()); else updateStatement.setNull(7, java.sql.Types.INTEGER);
            if (member.getBirthDate() != null) updateStatement.setDate(8, java.sql.Date.valueOf(member.getBirthDate())); else updateStatement.setNull(8, java.sql.Types.DATE);
            updateStatement.setString(9, member.getCoachName());
            updateStatement.setString(10, member.getCourseName());
            updateStatement.setString(11, member.getMemberName());

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
