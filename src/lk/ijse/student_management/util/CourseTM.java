package lk.ijse.student_management.util;

import java.math.BigDecimal;

public class CourseTM {

    private String cid;
    private String cname;
    private String ctype;
    private String duration;
    private BigDecimal cfee;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal dscfull;
    private BigDecimal dsctwice;

    public CourseTM() {
    }

    public CourseTM(String cid, String cname, String ctype, String duration, BigDecimal cfee, BigDecimal discount, BigDecimal tax, BigDecimal dscfull, BigDecimal dsctwice) {
        this.cid = cid;
        this.cname = cname;
        this.ctype = ctype;
        this.duration = duration;
        this.cfee = cfee;
        this.discount = discount;
        this.tax = tax;
        this.dscfull = dscfull;
        this.dsctwice = dsctwice;
    }

    public CourseTM(String cid, String cname, String ctype, String duration, BigDecimal cfee, BigDecimal dscfull, BigDecimal dsctwice) {
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
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
        return "CourseTM{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", ctype='" + ctype + '\'' +
                ", duration='" + duration + '\'' +
                ", cfee=" + cfee +
                ", discount=" + discount +
                ", tax=" + tax +
                ", dscfull=" + dscfull +
                ", dsctwice=" + dsctwice +
                '}';
    }
}
