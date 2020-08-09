package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Course;

import java.util.List;

public interface CourseDAO extends CrudDAO<Course,String> {

    String getlastCourseId() throws Exception;

    public Course getbyName(String name) throws Exception;

    public List<Course> searchAll(String key)throws Exception;

}
