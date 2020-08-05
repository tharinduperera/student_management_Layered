package lk.ijse.student_management.entity;

public class Course {

    private String cid;
    private String cname;
    private String ctype;
    private String duration;
    private double cfee;
    private double dscfull;
    private double dsctwice;

    public Course() {
    }

    public Course(String cid, String cname, String ctype, String duration, double cfee, double dscfull, double dsctwice) {
        this.cid = cid;
        this.cname = cname;
        this.ctype = ctype;
        this.duration = duration;
        this.cfee = cfee;
        this.dscfull = dscfull;
        this.dsctwice = dsctwice;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getCfee() {
        return cfee;
    }

    public void setCfee(double cfee) {
        this.cfee = cfee;
    }

    public double getDscfull() {
        return dscfull;
    }

    public void setDscfull(double dscfull) {
        this.dscfull = dscfull;
    }

    public double getDsctwice() {
        return dsctwice;
    }

    public void setDsctwice(double dsctwice) {
        this.dsctwice = dsctwice;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", ctype='" + ctype + '\'' +
                ", duration='" + duration + '\'' +
                ", cfee=" + cfee +
                ", dscfull=" + dscfull +
                ", dsctwice=" + dsctwice +
                '}';
    }
}
