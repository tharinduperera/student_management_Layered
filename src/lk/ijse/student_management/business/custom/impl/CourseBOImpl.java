package lk.ijse.student_management.business.custom.impl;

import lk.ijse.student_management.business.custom.CourseBO;
import lk.ijse.student_management.dao.DAOFactory;
import lk.ijse.student_management.dao.DAOTypes;
import lk.ijse.student_management.dao.custom.CourseDAO;
import lk.ijse.student_management.entity.Course;
import lk.ijse.student_management.util.CourseTM;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO = DAOFactory.getInstance().getDAO(DAOTypes.COURSE);

    @Override
    public String getCourseId() throws Exception {
        String lastCourseId = courseDAO.getlastCourseId();
        if (lastCourseId == null) {
            return "C001";
        } else {
            int maxId = Integer.parseInt(lastCourseId.replace("C", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "C00" + maxId;
            } else if (maxId < 100) {
                id = "C0" + maxId;
            } else {
                id = "C" + maxId;
            }
            return id;
        }
    }

    @Override
    public CourseTM getbyName(String cname) throws Exception {
        Course course = courseDAO.getbyName(cname);
        if(course != null){
            return new CourseTM(course.getCid(),course.getCname(),course.getCtype(),course.getDuration(),course.getCfee(),course.getDiscount(),course.getTax(),course.getDscfull(),course.getDsctwice());
        }
        return null;
    }

    @Override
    public List<CourseTM> getAllCourses() throws Exception {
        List<Course> allcCourses = courseDAO.getAll();
        List<CourseTM> courseTMS = new ArrayList<>();
        for (Course course: allcCourses) {
            courseTMS.add(new CourseTM(course.getCid(),course.getCname(),course.getCtype(),course.getDuration(),course.getCfee(),course.getDiscount(),course.getTax(),course.getDscfull(),course.getDsctwice()));
        }
        return courseTMS;
    }

    @Override
    public boolean saveCourse(CourseTM courseTM) throws Exception {
        return courseDAO.save(new Course(courseTM.getCid(),courseTM.getCname(),courseTM.getCtype(),courseTM.getDuration(),courseTM.getCfee(),courseTM.getDiscount(),courseTM.getTax(),courseTM.getDscfull(),courseTM.getDsctwice()));
    }

    @Override
    public boolean deleteCourse(String cid) throws Exception {
        return courseDAO.delete(cid);
    }

    @Override
    public boolean updateCourse(CourseTM courseTM) throws Exception {
        return courseDAO.update(new Course(courseTM.getCid(),courseTM.getCname(),courseTM.getCtype(),courseTM.getDuration(),courseTM.getCfee(),courseTM.getDiscount(),courseTM.getTax(),courseTM.getDscfull(),courseTM.getDsctwice()));
    }
}
