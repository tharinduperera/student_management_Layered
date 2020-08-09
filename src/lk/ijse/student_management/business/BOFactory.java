package lk.ijse.student_management.business;

import lk.ijse.student_management.business.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (boFactory == null) ? boFactory = new BOFactory(): boFactory;
    }


    public <T extends SuperBO> T getBO(BOTypes boTypes){
        switch (boTypes){
            case BATCH:
                return (T) new BatchBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case GUARDIAN:
                return (T) new GuardianBOImpl();
            default:
                return null;
        }
    }
}


