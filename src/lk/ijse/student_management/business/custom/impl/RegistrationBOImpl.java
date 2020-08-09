package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.RegistrationBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.GuardianDAO;
import lk.ijse.student_management.dao.custom.RegistrationDAO;
import lk.ijse.student_management.dao.custom.StudentDAO;
import lk.ijse.student_management.db.DBConnection;
import lk.ijse.student_management.entity.Batch;
import lk.ijse.student_management.entity.Guardian;
import lk.ijse.student_management.entity.Registration;
import lk.ijse.student_management.entity.Student;
import lk.ijse.student_management.util.BatchTM;
import lk.ijse.student_management.util.GuardianTM;
import lk.ijse.student_management.util.RegistrationTM;
import lk.ijse.student_management.util.StudentTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO = DAOFactory.getInstance().getDAO(DAOTypes.REGISTRATION);
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
    GuardianDAO guardianDAO = DAOFactory.getInstance().getDAO(DAOTypes.GUARDIAN);
    Connection connection = DBConnection.getInstance().getConnection();

    @Override
    public String getregistrationId() throws Exception {
        String lastRegistrationId = registrationDAO.getlastRegistrationId();
        if (lastRegistrationId == null) {
            return "R001";
        } else {
            int maxId = Integer.parseInt(lastRegistrationId.replace("R", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "R00" + maxId;
            } else if (maxId < 100) {
                id = "R0" + maxId;
            } else {
                id = "R" + maxId;
            }
            return id;
        }
    }

    @Override
    public RegistrationTM get(String rid) throws Exception {
        Registration registration = registrationDAO.findbyRID(rid);
        if(registration != null){
            return new RegistrationTM(registration.getBatchRegistrationPK().getRid(),registration.getBatchRegistrationPK().getBid(),registration.getNic(),registration.getRdate(),registration.getRfee());
        }
        return null;
    }

    @Override
    public List<RegistrationTM> getAllRegistrations() throws Exception {
        List<Registration> allRegistrations = registrationDAO.getAll();
        List<RegistrationTM> registrationTMS = new ArrayList<>();
        for (Registration registration : allRegistrations) {
            registrationTMS.add(new RegistrationTM(registration.getBatchRegistrationPK().getRid(),registration.getBatchRegistrationPK().getBid(),registration.getNic(),registration.getRdate(),registration.getRfee()));
        }
        return registrationTMS;
    }

    @Override
    public boolean register(RegistrationTM registrationTM, StudentTM studentTM, GuardianTM guardianTM) throws Exception {
       try {
            connection.setAutoCommit(false);

            boolean result = studentDAO.save(new Student(studentTM.getNic(),
                    studentTM.getNamewithinitials(),
                    studentTM.getFullname(),
                    studentTM.getGender(),
                    studentTM.getDob(),
                    studentTM.getAddress(),
                    studentTM.getTelhome(),
                    studentTM.getTelmobile(),
                    studentTM.getEmail(),
                    studentTM.getSchool(),
                    studentTM.getUniversity(),
                    studentTM.getQualifications()));

            if (!result) {
                connection.rollback();
                return false;
            }

            result = guardianDAO.save(new Guardian(guardianTM.getGid(),
                    guardianTM.getSdnic(),
                    guardianTM.getGname(),
                    guardianTM.getGaddress(),
                    guardianTM.getGtel(),
                    guardianTM.getGemail(),
                    guardianTM.getDesignation(),
                    guardianTM.getWorkplace()));

            if (!result) {
                connection.rollback();
                return false;
            }

            result = registrationDAO.save(new Registration(registrationTM.getRid(),
                    registrationTM.getBid(),
                    registrationTM.getNic(),
                    registrationTM.getRdate(),
                    registrationTM.getRfee()));

            if (!result) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteRegistration(String rid) throws Exception {
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationTM registrationTM, StudentTM studentTM, GuardianTM guardianTM) throws Exception {
        try {
            connection.setAutoCommit(false);

            boolean result = studentDAO.update(new Student(studentTM.getNic(),
                    studentTM.getNamewithinitials(),
                    studentTM.getFullname(),
                    studentTM.getGender(),
                    studentTM.getDob(),
                    studentTM.getAddress(),
                    studentTM.getTelhome(),
                    studentTM.getTelmobile(),
                    studentTM.getEmail(),
                    studentTM.getSchool(),
                    studentTM.getUniversity(),
                    studentTM.getQualifications()));

            if (!result) {
                connection.rollback();
                return false;
            }

            result = guardianDAO.update(new Guardian(guardianTM.getGid(),
                    guardianTM.getSdnic(),
                    guardianTM.getGname(),
                    guardianTM.getGaddress(),
                    guardianTM.getGtel(),
                    guardianTM.getGemail(),
                    guardianTM.getDesignation(),
                    guardianTM.getWorkplace()));

            if (!result) {
                connection.rollback();
                return false;
            }

            result = registrationDAO.update(new Registration(registrationTM.getRid(),
                    registrationTM.getBid(),
                    registrationTM.getNic(),
                    registrationTM.getRdate(),
                    registrationTM.getRfee()));

            if (!result) {
                connection.rollback();
                return false;
            }

            connection.commit();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<RegistrationTM> searchAll(String key) throws Exception {
        List<Registration>allRegistrations = registrationDAO.searchAll(key);
        List<RegistrationTM> registrationTMS = new ArrayList<>();
        for (Registration registration : allRegistrations) {
            registrationTMS.add(new RegistrationTM(registration.getBatchRegistrationPK().getRid(),registration.getBatchRegistrationPK().getBid(),registration.getNic(),registration.getRdate(),registration.getRfee()));
        }
        return registrationTMS;
    }
}
