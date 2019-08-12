package com.itdr.dao;

import com.itdr.pojo.Orders;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.Arrays;
import java.util.List;

public class OrderDao {
    //订单列表
    public List<Orders> selectAll(String pageSize, String pageNum) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from orders";
        List<Orders> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Orders>(Orders.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(li.get(0));
        return li;
    }
//订单查询
    public Orders selectOne(Integer orderNos) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from orders where orderNo=?";
        Orders ord = null;
        try {
           ord = qr.query(sql,new BeanHandler<Orders>(Orders.class),orderNos);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ord;
    }
//订单发货
    public int send_goods(Integer orderNos) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update orders set status = 1 where orderNo = ?";
        Orders u =null;
        int row = 0;
        try {
            row = qr.update(sql,orderNos);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }


}
