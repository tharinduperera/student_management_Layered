package lk.ijse.student_management.dao.custom.impl;

import lk.ijse.student_management.dao.CrudUtil;
import lk.ijse.student_management.dao.custom.CourseDAO;
import lk.ijse.student_management.entity.Course;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public List<Course> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM COURSE");
        List<Course> courses =  new ArrayList<>();
        while (resultSet.next()){
            courses.add(new Course(resultSet.getString("cid"),
                    resultSet.getString("cname"),
                    resultSet.getString("ctype"),
                    resultSet.getString("duration"),
                    resultSet.getBigDecimal("cfee"),
                    resultSet.getBigDecimal("dcsfull"),
                    resultSet.getBigDecimal("dcstwice")));
        }
        return courses;
    }

    @Override
    public Course find(String key) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM COURSE WHERE cid = ?",key);
        if(resultSet.next()){
            return new Course(resultSet.getString("cid"),
                    resultSet.getString("cname"),
                    resultSet.getString("ctype"),
                    resultSet.getString("duration"),
                    resultSet.getBigDecimal("cfee"),
                    resultSet.getBigDecimal("dcsfull"),
                    resultSet.getBigDecimal("dcstwice"));
        }
        return null;
    }

    @Override
    public boolean save(Course entity) throws Exception {
        return CrudUtil.execute("INSERT INTO COURSE VALUES(?,?,?,?,?,?,?)",entity.getCid(),entity.getCname(),entity.getCtype(),entity.getDuration(),entity.getCfee(),entity.getDscfull(),entity.getDsctwice());
    }

    @Override
    public boolean update(Course entity) throws Exception {
        return CrudUtil.execute("UPDATE COURSE SET cname=?,ctype=?,duration=?,cfee=?,dcsfull=?,dcstwice=? WHERE cid=?",entity.getCname(),entity.getCtype(),entity.getDuration(),entity.getCfee(),entity.getDscfull(),entity.getDsctwice(),entity.getCid());
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.execute("DELETE FROM COURSE WHERE cid = ?",key);
    }
}
