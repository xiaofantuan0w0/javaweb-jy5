package com.itdr.dao;

import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class ProductDao {
    //用户列表
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
    //按没姓名模糊查找
    public List<Products> selectnameOne(String productName) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from products where pname like ?";
        List<Products> li = null;
        productName = "%"+productName+"%";
        try {
            li = qr.query(sql,new BeanListHandler<Products>(Products.class),productName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return li;
    }
    //按照id查找
    public Products selectidOne(String producId) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        Integer pidd = Integer.parseInt(producId);
        String sql = "select * from products where pid=?";
        Products pro = null;
        try {
            pro = qr.query(sql,new BeanHandler<Products>(Products.class),pidd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
    }
    //根据id搜索详情
    public Products detailOne(String producId) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        Integer pid = Integer.parseInt(producId);
        String sql = "select * from products where pid=?";
        Products pro = null;
        try {
            pro = qr.query(sql,new BeanHandler<Products>(Products.class),pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return pro;
    }
    //上下架
    public int setsale(String producId,String status) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        Integer pid = Integer.parseInt(producId);
        Integer stats = Integer.parseInt(status);
        String sql = "Update products set stats = ? where pid = ?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,stats,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
    //新增
    public int xinzeng(String categoryId, String price, String pname, String stats) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        Integer cateid = Integer.parseInt(categoryId);
        Integer sta =Integer.parseInt(stats);
        String sql = "insert into products values(null,?,NULL,?,?,?)";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql ,pname,sta,cateid,price);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
    //更新
    public int gengxin(String pid, String categoryId, String price, String pname, String stats) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update products set categoryId=?,price=?,pname=?,mainImage=?,stats = ?,cuxiao=? where pid = ?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,categoryId ,price,pname,stats,pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
