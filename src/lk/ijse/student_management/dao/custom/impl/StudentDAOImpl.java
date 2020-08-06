package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.StudentDAO;
import lk.ijse.student_management.entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");
        List<Student> students = new ArrayList<>();
        while (resultSet.next()){
            students.add(new Student(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12)));
        }
        return students;
    }

    @Override
    public Student find(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE nic = ?",key);
        if(resultSet.next()){
            return new Student(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDate(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9),
                    resultSet.getString(10),
                    resultSet.getString(11),
                    resultSet.getString(12));
        }
        return null;
    }

    @Override
    public boolean save(Student entity) throws Exception {
        return CrudUtil.execute("InSERT INTO Student VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",entity.getNic(),entity.getNamewithinitials(),entity.getFullname(),entity.getGender(),entity.getDob(),entity.getAddress(),entity.getTelhome(),entity.getTelmobile(),entity.getEmail(),entity.getSchool(),entity.getUniversity(),entity.getQualifications());
    }

    @Override
    public boolean update(Student entity) throws Exception {
        return CrudUtil.execute("UPDATE STUDENT SET namewithinitials=?, fullname=?,gender=?,dob=?,address=?,telhome=?,telmobile=?,email=?,school=?,university_or_other=?,higher_education=? where nic=?",entity.getNamewithinitials(),entity.getFullname(),entity.getGender(),entity.getDob(),entity.getAddress(),entity.getTelhome(),entity.getTelmobile(),entity.getEmail(),entity.getSchool(),entity.getUniversity(),entity.getQualifications(),entity.getNic());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE nic = ?",key);
    }
}
