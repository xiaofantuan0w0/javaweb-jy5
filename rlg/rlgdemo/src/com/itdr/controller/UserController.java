package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PropertiesGetUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//list.do
@WebServlet(name = "UserController",value = "/manage/user/*")
public class UserController extends HttpServlet {
    UserService us = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建统一返回对象
        ResponseCode rs = null;
        //怎么获取请求路径
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        //判断一下是什么样的请求
        switch (path){
            case "list":
                rs = listDo(request);
                break;
            case "login":
                rs = logiDo(request);
                break;
            case "disableuser":
                rs = disableuser(request);
                break;
                default:
                    rs = ResponseCode.defeats(PropertiesGetUtil.getstatus("CANTFAND_CODE"),
                            PropertiesGetUtil.getValue("CANTFAND_MSG"));
                    break;
        }
        response.getWriter().write(rs.toString());
    }

    //获取所有用户列表需求
    private ResponseCode listDo (HttpServletRequest request){
        ResponseCode rs = new ResponseCode();
        String pagesize = request.getParameter("pagesize");
        String pagenum = request.getParameter("pagenum");
         rs = us.selectAll(pagesize,pagenum);

        return rs;
    }
    //用户登录的请求
    private ResponseCode logiDo (HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode rs = us.selectOne(username,password);
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getData());

        return rs;
    }
    //禁用用户
    private ResponseCode disableuser (HttpServletRequest request){
        String uid = request.getParameter("uid");
        ResponseCode rs = us.selectOne(uid);
        return rs;
    }
    //根据用户id察看用户详情
    //根据用户id求改用户信息
}
