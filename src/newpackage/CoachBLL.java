package newpackage;

import java.sql.SQLException;


public class CoachBLL {
    private CoachDAL coachDAL;

    public CoachBLL(CoachDAL coachDAL) {
        this.coachDAL = coachDAL;
    }

    public void createCoach(Coach coach) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            coachDAL.createCoach(coach);
        } catch (SQLException e) {
            throw new BusinessException("Failed to create coach.", e);
        }
    }

    public Coach[] getAllCoaches() throws BusinessException {
        try {
            return coachDAL.getAllCoach();
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve coaches.", e);
        }
    }

    public Coach getCoachByName(String coachName) throws BusinessException {
        try {
            return coachDAL.getCoachByName(coachName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve coach by ID.", e);
        }
    }

    public void updateCoach(Coach coach) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            coachDAL.updateCoach(coach);
        } catch (SQLException e) {
            throw new BusinessException("Failed to update coach.", e);
        }
    }

    public void deleteCoach(String coachName) throws BusinessException {
        // Perform any business validations or checks here
        // ...

        try {
            coachDAL.deleteCoach(coachName);
        } catch (SQLException e) {
            throw new BusinessException("Failed to delete coach.", e);
        }
    }
}
