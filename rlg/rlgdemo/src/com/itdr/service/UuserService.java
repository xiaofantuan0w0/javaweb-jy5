package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UuserDao;
import com.itdr.pojo.Users;
import com.itdr.pojo.Uusers;
import com.itdr.utils.PropertiesGetUtil;

public class UuserService {
     UuserDao uud = new UuserDao();
    //登录
    public ResponseCode selectOne(String username, String password) {
        if (username ==null ||username.equals("") || password.equals("")||password==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_CUO_CODE"),
                    PropertiesGetUtil.getValue("USER_CUO_MSG"));
        }
        //查找书否有这个用户
        Uusers u =  uud.selectOne(username, password);
        if (u ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_CUO_CODE"),
                    PropertiesGetUtil.getValue("USER_CUO_MSG"));
        }
        return ResponseCode.success(u);
    }
    //注册
    public ResponseCode registerDo(String username, String password, String email, String phone,
                                   String question, String answer) {
        if (username==""||username == null||password ==""||password==null||email==""||email==null||phone
                ==""||phone==null||question==""||question==null||answer==""||answer==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_NULL_CODE")
                    ,PropertiesGetUtil.getValue("PRODUCT_NULL_MSG"));
        }
     //   int row = uud.registerDo(username,password,email,phone,question,answer);
//        if (row<=0){
//            return ResponseCode.defeats(PropertiesGetUtil.getstatus("PRODUCT_XZ_CODE")
//                    ,PropertiesGetUtil.getValue("PRODUCT_XZ_MSG"));
//        }
//        return ResponseCode.success( "注册成功",row);
return null;
    }
}
