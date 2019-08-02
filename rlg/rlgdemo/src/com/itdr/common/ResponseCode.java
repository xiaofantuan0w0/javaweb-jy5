package com.itdr.common;

public class ResponseCode<T> {
    //返回状态码
    private Integer status;
    //返回数据
    private  T data;
    //返回错误信息
    private String mag;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        String a = "starus:"+this.getStatus()+
                ",data:"+this.getData()+
                ",Mag:"+this.getMag();
        return a;
    }


    //是否成功，成功返回状态码和成功获取的数据，
    // 失败返回状态码和失败的信息
   //  public

}
