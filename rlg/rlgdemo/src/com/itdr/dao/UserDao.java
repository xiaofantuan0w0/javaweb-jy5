package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
//用户数据层
public class UserDao {

   // 返回所有数据
    public List<Users> selectAll(String pagensize, String pagenum) {
        //获取连接
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from users";
        List<Users> li =null;
        try {
            li = qr.query(sql,new BeanListHandler<Users>(Users.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return li;
    }

    //根据用户名密码查找一个用户
    public Users selectOne(String username, String password) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from users where uname =? and psd = ?";
        Users u =null;
        try {
           u = qr.query(sql,new BeanHandler<Users>(Users.class),username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }
    //根据id查找一个用户
    public Users selectOne(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from users where uid = ?";
        Users u =null;
        try {
            u = qr.query(sql,new BeanHandler<Users>(Users.class),uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }
    //根据id禁用一个用户
    public int updateByUid(Integer uid) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update users set states = 1 where uid = ?";
        Users u =null;
        int row = 0;
        try {
            row = qr.update(sql,uid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return row;
    }
}
