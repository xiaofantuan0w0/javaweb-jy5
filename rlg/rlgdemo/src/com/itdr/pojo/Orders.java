package com.itdr.pojo;

public class Orders {
    private Integer orderNo;
    private Double payment;
   private Integer paymentType;
   private String paymentTypeDesc;
   private Integer postage;
   private Integer status;
   private String statusDesc;
   private String paymentTime;
    private String sendTime;
    private String closeTime;
    private String createTime;
   private String orderItemVoList;
   private String imageHost;
   private Integer shippingId;
   private String shippingVo;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }

    public void setPaymentTypeDesc(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(String orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getShippingVo() {
        return shippingVo;
    }

    public void setShippingVo(String shippingVo) {
        this.shippingVo = shippingVo;
    }

    @Override
    public String toString() {
        String a = "Pid:"+this.getOrderNo()+
                ",CategoryId:"+this.getShippingId()+
                ",MainImage:"+this.getPostage()+
                ",Cuxiao:"+this.getStatus()+
                ",Pname:"+this.getStatusDesc()
                +",Price:"+this.getShippingVo()+
                ",Stats:"+this.getOrderItemVoList()+
                 ",MainImage:"+this.getCloseTime()+
                ",Cuxiao:"+this.getCreateTime()+
                ",Pname:"+this.getPaymentTime()
                +",Price:"+this.getSendTime()+
                ",MainImage:"+this.getCloseTime()+
                ",Cuxiao:"+this.getCreateTime()+
                ",Pname:"+this.getPaymentTime()
                +",Price:"+this.getSendTime();

        return a;
    }
}
