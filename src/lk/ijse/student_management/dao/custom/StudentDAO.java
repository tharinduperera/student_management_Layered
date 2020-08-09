package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Registration;
import lk.ijse.student_management.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {

    public List<Student> searchAll(String key)throws Exception;

}
