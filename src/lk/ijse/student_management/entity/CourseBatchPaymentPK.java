package lk.ijse.student_management.entity;

public class CourseBatchPaymentPK implements SuperEntity{
    private String bid;
    private String cid;
    private String pid;

    public CourseBatchPaymentPK() {
    }

    public CourseBatchPaymentPK(String bid, String cid, String pid) {
        this.bid = bid;
        this.cid = cid;
        this.pid = pid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CourseBatchPaymentPK{" +
                "bid='" + bid + '\'' +
                ", cid='" + cid + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}
