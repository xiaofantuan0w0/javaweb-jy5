package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.UuserService;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PropertiesGetUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UuserController",value = "/user/*")
public class UuserController extends HttpServlet {
    UuserService uus = new UuserService();
    ResponseCode rs = new ResponseCode();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建统一返回对象
        ResponseCode rs = null;
        //怎么获取请求路径
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        //判断一下是什么样的请求
        switch (path){
            case "login":
                logiDo(request,response);
                break;
            case "register":
               rs = registerDo(request,response);
                break;
            case "ableuser":
            //    ableuser(request,response);
                break;
            default:
                rs = ResponseCode.defeats(PropertiesGetUtil.getstatus("CANTFAND_CODE"),
                        PropertiesGetUtil.getValue("CANTFAND_MSG"));
                break;
        }
        if (rs!=null){
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            response.getWriter().write(rs.toString());
        }
    }

    //登录
    private void logiDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResponseCode rs = uus.selectOne(username,password);
        //获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("user",rs.getData());
        //转到主页;
        if (rs.getStatus()==0){
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        }else {
            session.setAttribute("user",rs.getData());
            response.sendRedirect("/login.jsp");
        }
    }
    //注册
    private ResponseCode registerDo(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String question = request.getParameter("question");
        String answer =request.getParameter("answer");
        rs = uus.registerDo(username,password,email,phone,question,answer);
        return rs;
    }
}
