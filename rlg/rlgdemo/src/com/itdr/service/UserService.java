package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;
import com.itdr.utils.PropertiesGetUtil;

import java.util.List;
//用户业务层

public class UserService {
    UserDao ud = new UserDao();
    ResponseCode rs = new ResponseCode();

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
            rs.setStatus(00);
            rs.setMag("数据为空");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
    return rs;
    }
    //用户登录，返回一个
    public ResponseCode selectOne(String username, String password){
        if (username ==null ||username.equals("") || password.equals("")||password==null){
            rs.setStatus(1);
            rs.setMag("账户或密码错误");
            return rs;
        }
        //查找书否有这个用户
      Users u =  ud.selectOne(username, password);
        if (u ==null){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag("账户或密码错误");
            return rs;
        }
        if (u.getType()!=1){
            rs.setStatus(2);
            rs.setMag("没有操作权限！");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);
         return rs;
    }
    //禁用用户
    public ResponseCode selectOne(String uids){
        if (uids ==null ||uids.equals("")){
            rs.setStatus(Integer.parseInt(PropertiesGetUtil.getValue("USER_PARAMETER_CODE")));
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        //字符串转数值
        Integer uid = null;
        try {
           uid = Integer.parseInt(uids);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        //查找书否有这个用户
        Users u =  ud.selectOne(uid);
        //用户为空
        if (u ==null){
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }
        //
        if (u.getType()!=1){
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }
        //禁用用户
        int row = ud.updateByUid(uid);
        if (row<=0){
            rs.setStatus(106);
            rs.setMag("用户禁用更新失败");
            return rs;
        }
       rs.setStatus(0);
       rs.setData(row);
       rs.setMag("修改产品状态成功");
        return rs;
    }
    //
}
