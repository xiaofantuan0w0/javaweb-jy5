package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductD;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Products;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;

public class ProductService {
    ProductDao pd = new ProductDao();
    ProductD pdd = new ProductD();
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
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_FAND_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_FAND_MSG"));
        }
        return ResponseCode.success(li);
    }
    //商品搜索
    public ResponseCode selectOne(String productName, String producId) {
        ResponseCode rs = new ResponseCode();
        if (productName == null && producId == null ){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        Products pro = null;
        List<Products> li = null;
        if (producId ==null || producId.equals("")){
          li  = pd.selectnameOne(productName);
            if (li ==null){
                return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_CANT_CODE")
                        ,PropertiesGetUtil.getValue("PRODUCT_CANT_MSG"));
            }
          rs.setData(li);
        }
        if (productName == null || productName.equals("")){
            pro = pd.selectidOne(producId);
            if (pro== null){
                return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_CANT_CODE")
                        ,PropertiesGetUtil.getValue("PRODUCT_CANT_MSG"));
            }
            rs.setData(pro);
        }
         rs.setStatus(0);
         return rs;
    }
    //商品详情
    public ResponseCode detailOne(String producId) {
        if (producId ==null || producId.equals("")){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
            ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        Products pro = null;
        pro = pd.detailOne(producId);
        if (pro== null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_CANT_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_CANT_MSG"));
        }
        return ResponseCode.success(pro);
    }
    //商品上下架
    public ResponseCode setsale(String status, String producId) {
        int row = pd.setsale(producId,status);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_DEFEAT_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_DEFEAT_MSG"));
        }
        return ResponseCode.success("修改产品状态成功",row) ;
    }
    //新增
    public ResponseCode xinzeng(String price , String categoryId, String pname, String stats) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null||stats==""||stats==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        int row = pdd.xinzeng(categoryId,price,pname,stats);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_XZ_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_XZ_MSG"));
        }
        return ResponseCode.success( "新增产品成功",row);

    }
    //更新
    public ResponseCode gengxin(String pid, String price , String categoryId , String pname, String stats) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null|| stats==""||stats==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        Products pro = pd.selectidOne(pid);
        if (pro ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE")
                    ,PropertiesGetUtil.getValue("USER_NO_MSG"));
        }
        int row = pdd.gengxin(pid,price,categoryId,pname,stats); //pd.gengxin(pid,categoryId ,price,pname,stats);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_GX_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_GX_MSG"));
        }
        return ResponseCode.success("更新产品成功",row);

    }

}
