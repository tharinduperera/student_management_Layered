package lk.ijse.student_management.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Payment implements SuperEntity{


    private String pid;
    private String rid;
    private String nic;
    private String bid;
    private String ptype;
    private Date pdate;
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(String pid, String rid, String nic, String bid, String ptype, Date pdate, BigDecimal amount) {
        this.pid = pid;
        this.rid = rid;
        this.nic = nic;
        this.bid = bid;
        this.ptype = ptype;
        this.pdate = pdate;
        this.amount = amount;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pid='" + pid + '\'' +
                ", rid='" + rid + '\'' +
                ", nic='" + nic + '\'' +
                ", bid='" + bid + '\'' +
                ", ptype='" + ptype + '\'' +
                ", pdate=" + pdate +
                ", amount=" + amount +
                '}';
    }
}
