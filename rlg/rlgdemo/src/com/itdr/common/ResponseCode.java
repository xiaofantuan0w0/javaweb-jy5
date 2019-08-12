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
    public static <T> ResponseCode success (Integer status,T data){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        return rs;
    }
    public static <T> ResponseCode success (T data){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(data);
        return rs;
    }
    public static <T> ResponseCode success ( String mag,T data){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(data);
        rs.setMag(mag);
        return rs;
    }

    // 失败返回状态码和失败的信息
    public static  ResponseCode defeats (Integer status,String mag){
        ResponseCode rs = new ResponseCode();
        rs.setStatus(status);
        rs.setMag(mag);
        return rs;
    }
   //  public

}
