package com.itdr.testdemo2;

import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletKaoShi",value = "/shilian/*")
public class ServletKaoShi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        switch (path){
            case "kaoshi":
                kaoshi(request,response);
                break;
                case "zejian" :
                    zejian(request, response);
                    break;

        }

    }
    public static void kaoshi(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String zhou = "如意如意";
        String answer =  request.getParameter("answer");
        if (answer.equals(zhou)){
            response.sendRedirect("/zejian.jsp");
        }else {
            response.sendRedirect("/kaoshi.jsp");
        }
    }
    public static void zejian(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String a1 = request.getParameter("a1");
        String a2 = request.getParameter("a2");
        String a3 = request.getParameter("a3");
        String a4 = request.getParameter("a4");
        int sc = 0;
        if(a1.equals("滚")){
            sc += 10;
        }
        if(a2.equals("滚")){
            sc += 10;
        }
        if(a3.equals("滚")){
            sc += 10;
        }
        if(a4.equals("滚")){
            sc += 10;
        }
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        switch(sc){
            case 0:
                response.getWriter().write(" 呵呵");
                break;
            case 10:
                response.getWriter().write(" 再接再厉");
                break;
            case 20:
                response.getWriter().write(" 继续努力");
                break;
            case 30:
                response.getWriter().write(" 勉强合格");
                break;
            case 40:
                response.getWriter().write(" 通过试炼");
                break;

        }
    }
}
