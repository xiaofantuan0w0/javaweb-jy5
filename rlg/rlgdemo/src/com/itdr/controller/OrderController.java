package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.service.ProductService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderController",value = "/manage/order/*")
public class OrderController extends HttpServlet {
    ResponseCode rs = new ResponseCode();
    OrderService os = new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "send_goods":
                rs = send_goodsDo(request);
                break;
            default:
                rs.setStatus(404);
                rs.setMag("请求错误，找不到网页");
                break;
        }
        response.getWriter().write(rs.toString());
    }



    //订单列表
    private ResponseCode listDo(HttpServletRequest request) {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        rs = os.selectAll(pageSize,pageNum);
        return rs;
    }
    //按订单号查询
    private ResponseCode searchDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        rs = os.selectOne(orderNo);

        return rs;
    }
    //订单详情 ?????!!!!!!
    private ResponseCode detailDo(HttpServletRequest request) {
        return null;
    }
    //订单发货
    private ResponseCode send_goodsDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        rs = os.send_goods(orderNo);

        return rs;
    }

}
