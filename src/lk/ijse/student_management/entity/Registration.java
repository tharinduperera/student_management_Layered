package lk.ijse.student_management.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Registration implements SuperEntity{

    private BatchRegistrationPK batchRegistrationPK;
    private String nic;
    private Date rdate;
    private BigDecimal rfee;

    public Registration() {
    }

    public Registration(String rid,String bid, String nic, Date rdate, BigDecimal rfee) {
        this.batchRegistrationPK = new BatchRegistrationPK(rid,bid);
        this.nic = nic;
        this.rdate = rdate;
        this.rfee = rfee;
    }

    public BatchRegistrationPK getBatchRegistrationPK() {
        return batchRegistrationPK;
    }

    public void setBatchRegistrationPK(BatchRegistrationPK batchRegistrationPK) {
        this.batchRegistrationPK = batchRegistrationPK;
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
                "batchRegistrationPK=" + batchRegistrationPK +
                ", nic='" + nic + '\'' +
                ", rdate=" + rdate +
                ", rfee=" + rfee +
                '}';
    }
}
