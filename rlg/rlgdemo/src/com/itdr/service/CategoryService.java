package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Products;

public class CategoryService {
    ResponseCode rs = new ResponseCode();
    CategoryDao cd = new CategoryDao();
   //获得品类子节点
    public ResponseCode get_category(String parentId) {
        if (parentId ==null || parentId.equals("")){
            rs.setStatus(1);
            rs.setMag("传入数据为空");
            return rs;
        }
        Products pro = null;
        pro = cd.get_category(parentId);
        if (pro== null){
            rs.setStatus(100);
            rs.setMag("找不到商品");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(pro);
        return rs;
    }
}
