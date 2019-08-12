package com.itdr.dao;

import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;

public class ProductD {
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
    public int gengxin(String pid, String categoryId, String price, String pname, String stats) {
        QueryRunner qr = new QueryRunner(PoolUtil.getcom());
        String sql = "Update products set parentId=?,price=?,pname=?,stats = ? where pid = ?";
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
