package com.itdr.dao;

import com.itdr.pojo.Categorys;
import com.itdr.pojo.Products;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class CategoryDao {
    //获得品类子节点
    public List<Categorys> get_category(String parentId) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from categorys where parentId=?";
        List<Categorys> li = null;
        try {
            li = qr.query(sql,new BeanListHandler<Categorys>(Categorys.class),parentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return li;
    }
    //在父类增加节点
    public int add_category(String parentId, String categoryName) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "insert into categorys value(parentId=?,categoryName=?)";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,parentId,categoryName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
    //修改
    public int set_category(String parentId, String categoryName) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update categorys set categoryName=? where parentId=?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,parentId,categoryName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
