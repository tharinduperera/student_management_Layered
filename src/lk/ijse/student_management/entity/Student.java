package lk.ijse.student_management.entity;

import java.sql.Date;

public class Student implements SuperEntity{

    private String nic;
    private String namewithinitials;
    private String fullname;
    private String gender;
    private Date dob;
    private String address;
    private String telhome;
    private String telmobile;
    private String email;
    private String school;
    private String university;
    private String qualifications;


    public Student() {
    }

    public Student(String nic, String namewithinitials, String fullname, String gender, Date dob, String address, String telhome, String telmobile, String email, String school, String university, String qualifications) {
        this.nic = nic;
        this.namewithinitials = namewithinitials;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.telhome = telhome;
        this.telmobile = telmobile;
        this.email = email;
        this.school = school;
        this.university = university;
        this.qualifications = qualifications;
    }

    public Student(String nic, String namewithinitials, Date dob, String address, String telhome, String telmobile, String email, String school) {
        this.nic = nic;
        this.namewithinitials = namewithinitials;
        this.dob = dob;
        this.address = address;
        this.telhome = telhome;
        this.telmobile = telmobile;
        this.email = email;
        this.school = school;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getNamewithinitials() {
        return namewithinitials;
    }

    public void setNamewithinitials(String namewithinitials) {
        this.namewithinitials = namewithinitials;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelhome() {
        return telhome;
    }

    public void setTelhome(String telhome) {
        this.telhome = telhome;
    }

    public String getTelmobile() {
        return telmobile;
    }

    public void setTelmobile(String telmobile) {
        this.telmobile = telmobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nic='" + nic + '\'' +
                ", namewithinitials='" + namewithinitials + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", telhome='" + telhome + '\'' +
                ", telmobile='" + telmobile + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +
                ", university='" + university + '\'' +
                ", qualifications='" + qualifications + '\'' +
                '}';
    }
}
