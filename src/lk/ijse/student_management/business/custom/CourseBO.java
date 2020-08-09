package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.CourseTM;

import java.util.List;

public interface CourseBO extends SuperBO {

    public String getCourseId() throws Exception;

    public CourseTM getbyName(String name) throws Exception;

    public List<CourseTM> getAllCourses() throws Exception;

    public boolean saveCourse(CourseTM courseTM) throws Exception;

    public boolean deleteCourse(String cid) throws Exception;

    public boolean updateCourse(CourseTM courseTM) throws Exception;

    public List<CourseTM> searchAll(String key)throws Exception;
}
