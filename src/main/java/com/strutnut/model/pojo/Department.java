package com.strutnut.model.pojo;

public class Department {
    public Department(String bmxid, String bmxaddress) {
        this.bmxid = bmxid;
        this.bmxaddress = bmxaddress;
    }

    private String bmxid;
    private String bmxaddress;

    public String getbmxid() {
        return bmxid;
    }

    public void setbmxid(String bmxid) {
        this.bmxid = bmxid;
    }

    public String getbmxaddress() {
        return bmxaddress;
    }

    public void setbmxaddress(String bmxaddress) {
        this.bmxaddress = bmxaddress;
    }
}
