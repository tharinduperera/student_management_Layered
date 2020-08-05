package lk.ijse.student_management.entity;

import java.math.BigDecimal;

public class Course implements SuperEntity{

    private String cid;
    private String cname;
    private String ctype;
    private String duration;
    private BigDecimal cfee;
    private BigDecimal dscfull;
    private BigDecimal dsctwice;

    public Course() {
    }

    public Course(String cid, String cname, String ctype, String duration, BigDecimal cfee, BigDecimal dscfull, BigDecimal dsctwice) {
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

    public BigDecimal getCfee() {
        return cfee;
    }

    public void setCfee(BigDecimal cfee) {
        this.cfee = cfee;
    }

    public BigDecimal getDscfull() {
        return dscfull;
    }

    public void setDscfull(BigDecimal dscfull) {
        this.dscfull = dscfull;
    }

    public BigDecimal getDsctwice() {
        return dsctwice;
    }

    public void setDsctwice(BigDecimal dsctwice) {
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
