package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Categorys;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;

public class CategoryService {
    ResponseCode rs = new ResponseCode();
    CategoryDao cd = new CategoryDao();
    //获得品类子节点
    public ResponseCode get_category(String parentId) {
        if (parentId ==null || parentId.equals("")){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
        List<Categorys> li  = null;
        li = cd.get_category(parentId);
        if (li== null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("CATE_FANDPL_CODE")
                    ,PropertiesGetUtil.getValue("CATE_FANDPL_MSG"));
        }
        return ResponseCode.success(li);
    }
    //增加节点
    public ResponseCode add_category(String parentId, String categoryName) {
        if ( parentId.equals("")|| parentId==null){
            parentId = "0";
        }
//        Categorys cat =  cd.selectOne(uid);
//        //品类为空
//        if (u ==null){
//            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE"),
//                    PropertiesGetUtil.getValue("USER_NO_MSG"));
//        }
            //在父类增加
            int row = cd.add_category(parentId,categoryName);
            if (row<=0){
                return ResponseCode.defeats(PropertiesGetUtil.getstatus("CATE_TJ_CODE")
                        ,PropertiesGetUtil.getValue("CATE_TJ_MSG"));
            }
            return ResponseCode.success("添加品类成功",row);
    }
    //修改
    public ResponseCode set_category(String parentId, String categoryName) {
        if ( parentId.equals("")|| parentId==null){
            parentId = "0";
        }
//        Categorys cat =  cd.selectOne(uid);
//        //品类为空
//        if (u ==null){
//            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE"),
//                    PropertiesGetUtil.getValue("USER_NO_MSG"));
//        }
        int row = cd.set_category(parentId,categoryName);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("CATE_GG_CODE")
                    ,PropertiesGetUtil.getValue("CATE_GG+MSG"));
        }
        return ResponseCode.success("更新品类成功",row);
    }
}
