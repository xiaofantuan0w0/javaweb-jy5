package com.itdr.dao;

import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class ProductDao {
    public List<Products> selectAll(String pageSize,String pageNum) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from products";
        List<Products> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Products>(Products.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return li;
    }

    public Products selectnameOne(String productName) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from products where pname=?";
        Products pro = null;
        try {
            pro = qr.query(sql,new BeanHandler<Products>(Products.class),productName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
    }

    public Products selectidOne(String producId) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from products where pid=?";
        Products pro = null;
        try {
            pro = qr.query(sql,new BeanHandler<Products>(Products.class),producId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
    }
//上下架
    public int setsale(String producId,String status) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update products set stats = ? where pid = ?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,status,producId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
