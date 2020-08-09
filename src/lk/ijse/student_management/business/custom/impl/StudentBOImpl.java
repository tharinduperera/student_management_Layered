package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.StudentBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.GuardianDAO;
import lk.ijse.student_management.dao.custom.StudentDAO;
import lk.ijse.student_management.db.DBConnection;
import lk.ijse.student_management.entity.Guardian;
import lk.ijse.student_management.entity.Student;
import lk.ijse.student_management.util.GuardianTM;
import lk.ijse.student_management.util.StudentTM;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
    GuardianDAO guardianDAO = DAOFactory.getInstance().getDAO(DAOTypes.GUARDIAN);

    @Override
    public StudentTM get(String nic) throws Exception {
        Student student = studentDAO.find(nic);
        if(student != null){
            return new StudentTM(student.getNic(),student.getNamewithinitials(),student.getFullname(),student.getGender(),student.getDob(),student.getAddress(),student.getTelhome(),student.getTelmobile(),student.getEmail(),student.getSchool(),student.getUniversity(),student.getQualifications());
        }
        return null;
    }

    @Override
    public List<StudentTM> getAllStudent() throws Exception {
        List<Student> allStudents = studentDAO.getAll();
        List<StudentTM> studentTMS = new ArrayList<>();
        for (Student student : allStudents) {
            studentTMS.add(new StudentTM(student.getNic(),student.getNamewithinitials(),student.getFullname(),student.getGender(),student.getDob(),student.getAddress(),student.getTelhome(),student.getTelmobile(),student.getEmail(),student.getSchool(),student.getUniversity(),student.getQualifications()));
        }
        return studentTMS;
    }

    @Override
    public List<StudentTM> getAllStudentTable() throws Exception {
        List<Student> allStudents = studentDAO.getAll();
        List<StudentTM> studentTMS = new ArrayList<>();
        for (Student student : allStudents) {
            studentTMS.add(new StudentTM(student.getNic(),student.getNamewithinitials(),student.getDob(),student.getAddress(),student.getTelhome(),student.getTelmobile(),student.getEmail(),student.getSchool()));
        }
        return studentTMS;

    }

    @Override
    public boolean saveStudent(StudentTM studentTM, GuardianTM guardianTM) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
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
    public boolean deleteCourse(String nic) throws Exception {
        return studentDAO.delete(nic);
    }

    @Override
    public boolean updateCourse(StudentTM studentTM, GuardianTM guardianTM) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
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
}
