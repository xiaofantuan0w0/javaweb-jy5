package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProductController",value = "/manage/product/*")
public class ProductController extends HttpServlet {
    //注入灵魂
    ProductService ps = new ProductService();
    ResponseCode rs = new ResponseCode();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");

        ResponseCode rs = null;
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        switch (path){
            case "list":
                rs = listDo(request);
                break;
            case "search":
                rs = searchDo(request);
                break;
            case "detail":
                rs = detailDo(request);
                break;
            case "set_sale_status":
                rs = setSale(request);
        }
        response.getWriter().write(rs.toString());
    }




    //用户列表
    private ResponseCode listDo(HttpServletRequest request){

        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("user");
        if (user==null){
            rs.setStatus(10);
            rs.setMag("用户未登录，请登录");
            return rs;
        }
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        rs = ps.selectAll(pageSize,pageNum);
        return rs;
    }
    //用户搜索
    private ResponseCode searchDo(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("user");
        if (user==null){
            rs.setStatus(10);
            rs.setMag("用户未登录，请登录");
            return rs;
        }
//商品名字的模糊查询
        String productName = request.getParameter("productName");
        String producId = request.getParameter("producId");
        rs = ps.selectOne(productName,producId);

        return rs;
    }
    private ResponseCode detailDo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("user");
        if (user==null){
            rs.setStatus(10);
            rs.setMag("用户未登录，请登录");
            return rs;
        }
        String productName = request.getParameter("productName");
        String producId = request.getParameter("producId");
        rs = ps.selectOne(productName,producId);

        return rs;
    }
    //用户上下架
    private ResponseCode setSale(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("user");
        if (user==null){
            rs.setStatus(10);
            rs.setMag("用户未登录，请登录");
            return rs;
        }
        String status = request.getParameter("status");
        String producId = request.getParameter("producId");
        rs = ps.setsale(status,producId);

        return rs;
    }
}
