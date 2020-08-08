package lk.ijse.student_management.business.custom;

import lk.ijse.student_management.business.SuperBO;
import lk.ijse.student_management.util.CourseTM;
import lk.ijse.student_management.util.GuardianTM;
import lk.ijse.student_management.util.StudentTM;

import java.util.List;

public interface StudentBO extends SuperBO {

    public StudentTM get(String nic) throws Exception;

    public List<StudentTM> getAllStudent() throws Exception;

    public boolean saveStudent(StudentTM studentTM, GuardianTM guardianTM) throws Exception;

    public boolean deleteCourse(String nic) throws Exception;

    public boolean updateCourse(StudentTM studentTM, GuardianTM guardianTM) throws Exception;

}
