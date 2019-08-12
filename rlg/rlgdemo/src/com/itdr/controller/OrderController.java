package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PropertiesGetUtil;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
                rs = ResponseCode.defeats(PropertiesGetUtil.getstatus("CANTFAND_CODE"),
                        PropertiesGetUtil.getValue("CANTFAND_MSG"));
                break;
        }
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(JsonUtils.obj2String(rs));
      //  response.getWriter().write(rs.toString());
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
    //订单详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        rs = os.detailOne(orderNo);

        return rs;
    }
    //订单发货
    private ResponseCode send_goodsDo(HttpServletRequest request) {
        String orderNo = request.getParameter("orderNo");
        rs = os.send_goods(orderNo);

        return rs;
    }

}
