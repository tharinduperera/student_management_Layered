package lk.ijse.student_management.util;

public class GuardianTM {

    private String gid;
    private String sdnic;
    private String gname;
    private String gaddress;
    private String gtel;
    private String gemail;
    private String designation;
    private String workplace;

    public GuardianTM() {
    }

    public GuardianTM(String gid, String sdnic, String gname, String gaddress, String gtel, String gemail, String designation, String workplace) {
        this.gid = gid;
        this.sdnic = sdnic;
        this.gname = gname;
        this.gaddress = gaddress;
        this.gtel = gtel;
        this.gemail = gemail;
        this.designation = designation;
        this.workplace = workplace;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getSdnic() {
        return sdnic;
    }

    public void setSdnic(String sdnic) {
        this.sdnic = sdnic;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGaddress() {
        return gaddress;
    }

    public void setGaddress(String gaddress) {
        this.gaddress = gaddress;
    }

    public String getGtel() {
        return gtel;
    }

    public void setGtel(String gtel) {
        this.gtel = gtel;
    }

    public String getGemail() {
        return gemail;
    }

    public void setGemail(String gemail) {
        this.gemail = gemail;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "GuardianTM{" +
                "gid='" + gid + '\'' +
                ", sdnic='" + sdnic + '\'' +
                ", gname='" + gname + '\'' +
                ", gaddress='" + gaddress + '\'' +
                ", gtel='" + gtel + '\'' +
                ", gemail='" + gemail + '\'' +
                ", designation='" + designation + '\'' +
                ", workplace='" + workplace + '\'' +
                '}';
    }
}
