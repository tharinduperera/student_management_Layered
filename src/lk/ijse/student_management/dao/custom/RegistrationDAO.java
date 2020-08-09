package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Batch;
import lk.ijse.student_management.entity.BatchRegistrationPK;
import lk.ijse.student_management.entity.Registration;
import lk.ijse.student_management.util.RegistrationTM;

import java.util.List;

public interface RegistrationDAO extends CrudDAO<Registration, BatchRegistrationPK> {

    String getlastRegistrationId() throws Exception;

    public Registration findbyRID(String rid)throws Exception;

    public List<Registration> searchAll(String key)throws Exception;

}
