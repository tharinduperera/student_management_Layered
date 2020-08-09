package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.UserTM;

public interface UserBO extends SuperBO {

    public boolean login(UserTM userTM)throws Exception;
}
