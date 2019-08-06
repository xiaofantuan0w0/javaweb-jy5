package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;
//用户业务层

public class UserService {
    UserDao ud = new UserDao();

    //返回全部信息
    public ResponseCode selectAll(String pagensize, String pagenum) {
        //先判断信息是否为空
    if (pagensize==null || pagensize.equals("")){
        pagensize = "10";
    }
    if (pagenum==null|| pagensize.equals("")){
        pagenum = "1";
    }

    List<Users> li = ud.selectAll(pagensize,pagenum);

    //如果集合元素为空
        if (li ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NULL_CODE"),
                    PropertiesGetUtil.getValue("USER_NULL_MSG"));
        }
    return ResponseCode.success(li);
    }
    //用户登录，返回一个
    public ResponseCode selectOne(String username, String password){
        if (username ==null ||username.equals("") || password.equals("")||password==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_CUO_CODE"),
                    PropertiesGetUtil.getValue("USER_CUO_MSG"));
        }
        //查找书否有这个用户
      Users u =  ud.selectOne(username, password);
        if (u ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_CUO_CODE"),
                    PropertiesGetUtil.getValue("USER_CUO_MSG"));
        }
         return ResponseCode.success(u);
    }
    //禁用用户
    public ResponseCode selectOne(String uids){
        if (uids ==null ||uids.equals("")){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_PARAMETER_CODE"),
                    PropertiesGetUtil.getValue("USER_PARAMETER_MSG"));
        }
        //字符串转数值
        Integer uid = null;
        try {
           uid = Integer.parseInt(uids);
        }catch (Exception e){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_WROING_CODE"),
                    PropertiesGetUtil.getValue("USER_WROING_MSG"));
        }
        //查找书否有这个用户
        Users u =  ud.selectOne(uid);
        //用户为空
        if (u ==null){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_NO_CODE"),
                    PropertiesGetUtil.getValue("USER_NO_MSG"));
        }
        //
        if (u.getType()!=1){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_DISABLE_CODE"),
                    PropertiesGetUtil.getValue("USER_DISABLE_MSG"));
        }
        //禁用用户
        int row = ud.updateByUid(uid);
        if (row<=0){
            return ResponseCode.defeats(PropertiesGetUtil.getstatus("USER_DEFEAT_CODE"),
                    PropertiesGetUtil.getValue("USER_DEFEAT_MSG"));
        }
        return ResponseCode.success(row);
    }

}
