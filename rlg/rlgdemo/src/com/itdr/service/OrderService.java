package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Orders;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;

import java.util.List;

public class OrderService {
    ResponseCode rs = new ResponseCode();
    OrderDao od = new OrderDao();
    //用户列表
    public ResponseCode selectAll(String pageSize, String pageNum) {
        if (pageSize==null || pageSize.equals("")){
            pageSize = "10";
        }
        if (pageNum==null|| pageNum.equals("")){
            pageNum = "1";
        }

        List<Products> li = od.selectAll(pageSize,pageNum);
        if (li ==null){
            rs.setStatus(00);
            rs.setMag("数据为空");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
    //订单查询
    public ResponseCode selectOne(String orderNo) {
        if ( orderNo.equals("")|| orderNo==null){
            rs.setStatus(1);
            rs.setMag("没有当前订单号");
            return rs;
        }
        //字符串转数值
        Integer orderNos = null;
        try {
            orderNos= Integer.parseInt(orderNo);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        //查找书否有这个用户
        Orders ord =  od.selectOne(orderNos);
        if (ord ==null){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag("没有找到订单");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(ord);
        return rs;
    }
     //订单发货
    public ResponseCode send_goods(String orderNo) {
        if ( orderNo.equals("")|| orderNo==null){
            rs.setStatus(1);
            rs.setMag("没有当前订单号");
            return rs;
        }
        Integer orderNos = null;
        try {
            orderNos= Integer.parseInt(orderNo);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        //查找书否有这个用户
        Orders ord =  od.selectOne(orderNos);
        if (ord ==null){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag("没有找到订单");
            return rs;
        }
        if (ord.getStatus()!=1){
            rs.setStatus(2);
            rs.setMag("订单已发货");
            return rs;
        }
        int row = od.send_goods(orderNos);
        if (row<=0){
            rs.setStatus(106);
            rs.setMag("发货失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("发货成功");
        return rs;
    }
}
