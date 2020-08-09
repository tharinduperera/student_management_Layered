package lk.ijse.student_management.dao.custom;

import lk.ijse.student_management.dao.CrudDAO;
import lk.ijse.student_management.entity.Course;

public interface CourseDAO extends CrudDAO<Course,String> {

    String getlastCourseId() throws Exception;

    public Course getbyName(String name) throws Exception;

}
