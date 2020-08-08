package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.CourseBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.CourseDAO;
import lk.ijse.student_management.util.CourseTM;

import java.util.List;

public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);

    @Override
    public String getCourseId() throws Exception {

    }

    @Override
    public List<CourseTM> getAllCourses() throws Exception {

    }

    @Override
    public boolean saveCourse(CourseTM courseTM) throws Exception {
        return false;
    }

    @Override
    public boolean deleteCourse(String cid) throws Exception {
        return false;
    }

    @Override
    public boolean updateCourse(CourseTM courseTM) throws Exception {
        return false;
    }
}
