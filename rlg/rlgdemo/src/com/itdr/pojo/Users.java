package com.itdr.pojo;

public class Users {
    private Integer uid ;
    private String uname;
    private String psd;
    private String tel;
    //普通用户=0；管理员=1
    private Integer type = 0;
    //是否禁用
    private Integer states = 0;


    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsd() {
        return psd;
    }
    public void setPsd(String psd) {
        this.psd = psd;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStates() {
        return states;
    }
    public void setStates(Integer states) {
        this.states = states;
    }

    @Override
    public String toString() {
        String a = "uid:"+this.getUid()+
                ",uname:"+this.getUname()+
                ",psd:"+this.getPsd()+
                ",tel:"+this.getTel()+
                ",type:"+this.getType()
                +",states:"+this.getStates();
        return a;
    }
}
