package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.GuardianTM;
import lk.ijse.student_management.util.RegistrationTM;
import lk.ijse.student_management.util.StudentTM;

import java.util.List;

public interface RegistrationBO extends SuperBO {

    public RegistrationTM get(String rid) throws Exception;

    public List<RegistrationTM> getAllRegistrations() throws Exception;

    public boolean register(RegistrationTM registrationTM,StudentTM studentTM, GuardianTM guardianTM) throws Exception;

    public boolean deleteRegistration(String rid) throws Exception;

    public boolean updateRegistration(RegistrationTM registrationTM,StudentTM studentTM, GuardianTM guardianTM) throws Exception;

}
