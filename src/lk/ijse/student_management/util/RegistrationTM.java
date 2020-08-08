package lk.ijse.student_management.util;

import java.math.BigDecimal;
import java.sql.Date;

public class RegistrationTM {

    private String rid;
    private String bid;
    private String nic;
    private Date rdate;
    private BigDecimal rfee;

    public RegistrationTM() {
    }

    public RegistrationTM(String rid, String bid, String nic, Date rdate, BigDecimal rfee) {
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
        return "RegistrationTM{" +
                "rid='" + rid + '\'' +
                ", bid='" + bid + '\'' +
                ", nic='" + nic + '\'' +
                ", rdate=" + rdate +
                ", rfee=" + rfee +
                '}';
    }
}
