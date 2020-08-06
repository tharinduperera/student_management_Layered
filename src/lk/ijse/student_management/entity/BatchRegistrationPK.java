package lk.ijse.student_management.entity;

import java.io.Serializable;

public class BatchRegistrationPK implements SuperEntity {

    private String rid;
    private String bid;

    public BatchRegistrationPK() {
    }

    public BatchRegistrationPK(String rid, String bid) {
        this.rid = rid;
        this.bid = bid;
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

    @Override
    public String toString() {
        return "BatchRegistrationPK{" +
                "rid='" + rid + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }
}
