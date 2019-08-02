package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    ProductDao pd = new ProductDao();
   ResponseCode rs = new ResponseCode();

//用户列表
    public ResponseCode selectAll(String pageSize,String pageNum) {
        if (pageSize==null || pageSize.equals("")){
            pageSize = "10";
        }
        if (pageNum==null|| pageNum.equals("")){
            pageNum = "1";
        }

        List<Products> li = pd.selectAll(pageSize,pageNum);
        if (li ==null){
            rs.setStatus(00);
            rs.setMag("数据为空");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//用户搜索,详情
    public ResponseCode selectOne(String productName, String producId) {
        if (productName == null && producId == null ){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        Products pro = null;
        if (producId ==null || producId ==""){
           pro = pd.selectnameOne(productName);
        }
        if (productName == null || productName == ""){
            pro = pd.selectidOne(producId);
        }

         if (pro== null){
           rs.setStatus(100);
           rs.setMag("找不到商品");
         }
         rs.setStatus(0);
        rs.setData(pro);
        return rs;
    }
    //用户上下架
    public ResponseCode setsale(String status, String producId) {
        if (status == null ||status == "" ||producId == ""|| producId == null ){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }

        Products pro = pd.selectidOne(producId);
        if (pro ==null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }

        int row = pd.setsale(producId,status);
        if (row<=0){
            rs.setStatus(1);
            rs.setMag("修改产品状态失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("修改产品状态成功");
        return rs;
    }
}
