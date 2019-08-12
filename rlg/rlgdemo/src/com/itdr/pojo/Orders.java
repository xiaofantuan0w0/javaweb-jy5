package com.itdr.pojo;

public class Orders {
    private Integer orderNo;
    //总价格
    private String payment;
    //订单状态 0：未发货 1：已发货
   private Integer status;
   private String orderItemVoList;
   //商品数，商品数据
   private Integer shippingId;
   private String shippingVo;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(String orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
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

//    @Override
//    public String toString() {
//        return "{"+
//                "orderNo:"+orderNo+
//                ",payment："+payment+
//                ",status："+status+
//                ",orderItemVoList:"+orderItemVoList+
//                ",shippingId："+shippingId+
//                ",shippingVo:"+shippingVo+"\'"
//                +"}";
//    }
}
