package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Products;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;

public class ProductService {
    ProductDao pd = new ProductDao();

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
            rs.setData(pro.getPname());
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
        if (status == null ||status == "" ||producId == ""|| producId == null ){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }

        Products pro = pd.selectidOne(producId);
        if (pro ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE")
                    ,PropertiesGetUtil.getValue("USER_NO_MSG"));
        }

        int row = pd.setsale(producId,status);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_DEFEAT_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_DEFEAT_MSG"));
        }
        return ResponseCode.success("修改产品状态成功",row) ;
    }
    //新增
    public ResponseCode xinzeng(String categoryId, String price, String pname,
                                String mainImage, String stats, String cuxiao) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null||mainImage
                ==""||mainImage==null||stats==""||stats==null||cuxiao==""||cuxiao==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        int row = pd.xinzeng(categoryId ,price,pname, mainImage
                ,stats,cuxiao);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_XZ_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_XZ_MSG"));
        }
        return ResponseCode.success( "新增产品成功",row);

    }
    //更新
    public ResponseCode gengxin(String pid, String categoryId, String price,
                                String pname, String mainImage, String stats, String cuxiao) {
        if (categoryId==""||categoryId == null||price ==""||price==null||pname==""||pname==null||mainImage
                ==""||mainImage==null||stats==""||stats==null||cuxiao==""||cuxiao==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        Products pro = pd.selectidOne(pid);
        if (pro ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE")
                    ,PropertiesGetUtil.getValue("USER_NO_MSG"));
        }
        int row = pd.gengxin(pid,categoryId ,price,pname, mainImage
                ,stats,cuxiao);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_GX_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_GX_MSG"));
        }
        return ResponseCode.success("更新产品成功",row);

    }


}
