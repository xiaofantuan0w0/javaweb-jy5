package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.pojo.Orders;
import com.itdr.pojo.Products;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;

public class OrderService {
    OrderDao od = new OrderDao();
    //用户列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if (pageSize==null || pageSize.equals("")){
            pageSize = "10";
        }
        if (pageNum==null|| pageNum.equals("")){
            pageNum = "1";
        }

        List<Orders> li = od.selectAll(pageSize,pageNum);
        if (li ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_FAND_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_FAND_MSG"));
        }
        return ResponseCode.success(li);
    }
    //订单查询
    public ResponseCode selectOne(String orderNo) {
        if ( orderNo.equals("")|| orderNo==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_FANDDD_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_FANDDD_MSG"));
        }
        //字符串转数值
        Integer orderNos = Integer.parseInt(orderNo);
        //查找书否有这个用户
        Orders ord =  od.selectOne(orderNos);
        if (ord ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_NULLDD_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_NULLDD_MSG"));
        }
        return ResponseCode.success(ord);
    }
     //订单发货
    public ResponseCode send_goods(String orderNo) {
        if ( orderNo.equals("")|| orderNo==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_FANDDD_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_FANDDD_MSG"));
        }
        Integer orderNos = Integer.parseInt(orderNo);

        //查找书否有这个用户
        int row = od.send_goods(orderNos);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_FH_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_FH_MSG"));
        }
        return ResponseCode.success("发货成功",row);
    }
    //订单详情
    public ResponseCode detailOne(String orderNo) {
        if ( orderNo.equals("")|| orderNo==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_FANDDD_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_FANDDD_MSG"));
        }
        //字符串转数值
        Integer orderNos = null;
        try {
            orderNos= Integer.parseInt(orderNo);
        }catch (Exception e){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_WROING_CODE")
                    ,PropertiesGetUtil.getValue("USER_WROING_MSG"));
        }
        //查找书否有这个用户
        Orders ord =  od.selectOne(orderNos);
        if (ord ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("ORDER_NULLDD_CODE")
                    ,PropertiesGetUtil.getValue("ORDER_NULLDD_MSG"));
        }
        return ResponseCode.success(ord);
    }
}
