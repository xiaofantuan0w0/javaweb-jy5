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

    //商品列表
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
    //商品搜索
    public ResponseCode selectOne(String productName, String producId) {
        if (productName == null && producId == null ){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        Products pro = null;
        List<Products> li = null;
        if (producId ==null || producId.equals("")){
          li  = pd.selectnameOne(productName);
            rs.setData(li);
        }
        if (productName == null || productName.equals("")){
            pro = pd.selectidOne(producId);
            rs.setData(pro);
        }

         if (pro== null || li ==null){
           rs.setStatus(100);
           rs.setMag("找不到商品");
           return rs;
         }
         rs.setStatus(0);
         return rs;
    }
    //商品详情
    public ResponseCode detailOne(String producId) {
        if (producId ==null || producId.equals("")){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        Products pro = null;
        pro = pd.detailOne(producId);
        if (pro== null){
            rs.setStatus(100);
            rs.setMag("找不到商品");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(pro);
        return rs;
    }
    //商品上下架
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
    //新增
    public ResponseCode xinzeng(String categoryId, String price, String pname,
                                String mainImage, String stats, String cuxiao) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null||mainImage
                ==""||mainImage==null||stats==""||stats==null||cuxiao==""||cuxiao==null){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        int row = pd.xinzeng(categoryId ,price,pname, mainImage
                ,stats,cuxiao);
        if (row<=0){
            rs.setStatus(1);
            rs.setMag("新增产品失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("新增产品成功");
        return rs;

    }
    //更新
    public ResponseCode gengxin(String pid, String categoryId, String price,
                                String pname, String mainImage, String stats, String cuxiao) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null||mainImage
                ==""||mainImage==null||stats==""||stats==null||cuxiao==""||cuxiao==null){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        Products pro = pd.selectidOne(pid);
        if (pro ==null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        int row = pd.gengxin(pid,categoryId ,price,pname, mainImage
                ,stats,cuxiao);
        if (row<=0){
            rs.setStatus(1);
            rs.setMag("更新产品失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        rs.setMag("更新产品成功");
        return rs;

    }


}
