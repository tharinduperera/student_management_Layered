package lk.ijse.student_management.entity;

import java.io.Serializable;

public class BatchRegistrationPK implements SuperEntity {

    private String bid;
    private String rid;

    public BatchRegistrationPK() {
    }

    public BatchRegistrationPK(String bid, String rid) {
        this.bid = bid;
        this.rid = rid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "BatchRegistrationPK{" +
                "bid='" + bid + '\'' +
                ", rid='" + rid + '\'' +
                '}';
    }
}
