package newpackage;


import java.sql.SQLException;

/**
 *
 * @author WIN(10)X64
 */
public class ReceptionistBLL {
    private ReceptionistDAL ReceptionistDAL;
    public ReceptionistBLL(ReceptionistDAL ReceptionistDAL){
        this.ReceptionistDAL=ReceptionistDAL;
    }
    public void create (Receptionist Receptionist) throws BusinessException{
       try{
        ReceptionistDAL.createReceptionist(Receptionist);
       }
       catch(SQLException e){
            throw new BusinessException("Failed to Create Receptionist ", e);
        }
    }
    public void update(Receptionist Receptionist) throws BusinessException {
        try {
            ReceptionistDAL.updateReceptionist(Receptionist);
        } catch (SQLException e) {
            throw new BusinessException("Failed to update Receptionist", e);
        }
    }

    public Receptionist[] getAll() throws BusinessException {
        try {
            return ReceptionistDAL.getAllReceptionists();
        } catch (SQLException e) {
            throw new BusinessException("Failed to retrieve receptionists", e);
        }
    }

    public void delete(Receptionist Receptionist) throws BusinessException, SQLException {
        ReceptionistDAL.deleteReceptionist(Receptionist.getName());
    }
          
}