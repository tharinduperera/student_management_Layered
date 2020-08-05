package lk.ijse.student_management.entity;

public class Batch {

    private String bid;
    private String bname;
    private String cid;
    private String cname;
    private String startdate;


    public Batch() {
    }

    public Batch(String bid, String bname, String cid, String cname, String startdate) {
        this.bid = bid;
        this.bname = bname;
        this.cid = cid;
        this.cname = cname;
        this.startdate = startdate;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Override
    public String toString() {
        return "Batch{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", startdate='" + startdate + '\'' +
                '}';
    }
}
