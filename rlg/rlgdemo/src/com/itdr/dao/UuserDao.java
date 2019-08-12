package com.itdr.dao;

import com.itdr.pojo.Uusers;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UuserDao {
    public Uusers selectOne(String username, String password) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "select * from users where username =? and password = ?";
        Uusers u =null;
        try {
            u = qr.query(sql,new BeanHandler<Uusers>(Uusers.class),username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return u;
    }
}
