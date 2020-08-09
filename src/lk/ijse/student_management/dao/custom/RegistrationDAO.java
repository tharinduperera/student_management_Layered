package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.BatchRegistrationPK;
import lk.ijse.student_management.entity.Registration;
import lk.ijse.student_management.util.RegistrationTM;

public interface RegistrationDAO extends CrudDAO<Registration, BatchRegistrationPK> {

    String getlastRegistrationId() throws Exception;

    public Registration findbyRID(String rid)throws Exception;

}
