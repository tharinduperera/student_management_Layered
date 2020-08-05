package lk.ijse.student_management.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Registration implements SuperEntity{

    private String rid;
    private String bid;
    private String nic;
    private Date rdate;
    private BigDecimal rfee;

    public Registration() {
    }

    public Registration(String rid, String bid, String nic, Date rdate, BigDecimal rfee) {
        this.rid = rid;
        this.bid = bid;
        this.nic = nic;
        this.rdate = rdate;
        this.rfee = rfee;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public BigDecimal getRfee() {
        return rfee;
    }

    public void setRfee(BigDecimal rfee) {
        this.rfee = rfee;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "rid='" + rid + '\'' +
                ", bid='" + bid + '\'' +
                ", nic='" + nic + '\'' +
                ", rdate=" + rdate +
                ", rfee=" + rfee +
                '}';
    }
}
