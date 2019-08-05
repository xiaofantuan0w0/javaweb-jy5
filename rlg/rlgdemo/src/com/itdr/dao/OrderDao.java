package com.itdr.dao;

import com.itdr.pojo.Orders;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class OrderDao {
    //订单列表
    public List<Products> selectAll(String pageSize, String pageNum) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from orders";
        List<Products> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Products>(Products.class));
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public int send_goods(Integer orderNos) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update orders set states = 1 where orderNo = ?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,orderNos);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
