package newpackage;

import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;

import java.sql.SQLException;

public class MemberBLL {
    private MemberDAL memberDAL;

    public MemberBLL(MemberDAL memberDAL) {
        this.memberDAL = memberDAL;
    }

    public void createMember(Member member) throws BusinessException, SQLException {
        // Perform any business validations or checks here
        // ...

        try {
            memberDAL.createMember(member);
        } catch (SQLException e) {
            throw new BusinessException("Failed to create member.", e);
        }
        
    }

//    public Member[] getAllMembers() throws BusinessException {
//        try {
//            return memberDAL.getAllMembers();
//        } catch (SQLException e) {
//            throw new BusinessException("Failed to retrieve member.", e);
//        }
//    }

    public Member getMemberByName(String MemberName) throws BusinessException {
        try {
            return memberDAL.getMemberByName(MemberName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve member by Name.", e);
        }
    }

    public void updateMember(Member member) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            memberDAL.updateMember(member);
        } catch (SQLException e) {
            throw new BusinessException("Failed to update member.", e);
        }
    }

    public void deleteMember(String memberName) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            memberDAL.deleteMember(memberName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to delete member.", e);
        }
    }
}