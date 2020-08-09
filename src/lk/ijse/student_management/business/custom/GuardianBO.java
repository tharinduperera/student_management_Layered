package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.GuardianTM;

public interface GuardianBO extends SuperBO {

    public String getGuardianId() throws Exception;

    public GuardianTM getguardian(String nic) throws Exception;
}
