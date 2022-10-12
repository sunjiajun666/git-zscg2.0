package buba.com.cn.entity;

public class Service {
    private Integer sid;
    private Integer department;
    private String sname;
    private String province;
    private  Integer numbera;
    private  String  slock;

    public Service() {
    }

    public Service(Integer sid, Integer department, String sname, String province, Integer numbera, String slock) {
        this.sid = sid;
        this.department = department;
        this.sname = sname;
        this.province = province;
        this.numbera = numbera;
        this.slock = slock;
    }

    @Override
    public String toString() {
        return "Service{" +
                "sid=" + sid +
                ", department=" + department +
                ", sname='" + sname + '\'' +
                ", province='" + province + '\'' +
                ", numbera=" + numbera +
                ", slock='" + slock + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getNumbera() {
        return numbera;
    }

    public void setNumbera(Integer numbera) {
        this.numbera = numbera;
    }

    public String getSlock() {
        return slock;
    }

    public void setSlock(String slock) {
        this.slock = slock;
    }
}
