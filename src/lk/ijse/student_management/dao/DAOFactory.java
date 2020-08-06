package lk.ijse.student_management.dao;

import lk.ijse.student_management.business.custom.impl.BatchBOImpl;
import lk.ijse.student_management.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (daoFactory == null) ? daoFactory = new DAOFactory(): daoFactory;
    }


    public <T extends SuperDAO> T getDAO(DAOTypes DaoTypes){
        switch (DaoTypes){
            case BATCH:
                return (T) new BatchBOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case GUARDIAN:
                return (T) new GuardianDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case USER:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
