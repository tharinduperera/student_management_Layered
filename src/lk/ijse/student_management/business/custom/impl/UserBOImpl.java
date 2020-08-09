package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.UserBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.UserDAO;
import lk.ijse.student_management.entity.User;
import lk.ijse.student_management.util.UserTM;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOTypes.USER);

    @Override
    public boolean login(UserTM userTM) throws Exception {
        return userDAO.login(new User(userTM.getUsername(),userTM.getPassword()));
    }
}
