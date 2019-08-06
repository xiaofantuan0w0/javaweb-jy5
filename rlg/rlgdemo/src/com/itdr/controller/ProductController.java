package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PropertiesGetUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.geom.RectangularShape;
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
                break;
            case "save":
                rs = saveDo(request);
                break;
            default:
                rs = ResponseCode.defeats(PropertiesGetUtil.getstatus("CANTFAND_CODE"),
                        PropertiesGetUtil.getValue("CANTFAND_MSG"));
                break;
        }
        response.getWriter().write(rs.toString());
    }


    //用户列表
    private ResponseCode listDo(HttpServletRequest request){
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        rs = ps.selectAll(pageSize,pageNum);
        return rs;
    }
    //用户搜索
    private ResponseCode searchDo(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        String producId = request.getParameter("producId");
        rs = ps.selectOne(productName,producId);

        return rs;
    }
    //商品详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String producId = request.getParameter("producId");
        rs = ps.detailOne(producId);

        return rs;
    }
    //用户上下架
    private ResponseCode setSale(HttpServletRequest request) {
        String status = request.getParameter("status");
        String producId = request.getParameter("producId");
        rs = ps.setsale(status,producId);

        return rs;
    }
    //新增,更新产品
    private ResponseCode saveDo(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        String categoryId = request.getParameter("categoryId");
        String price = request.getParameter("price");
        String pname = request.getParameter("pname");
        String mainImage = request.getParameter("mainImage");
        String stats =request.getParameter("stats");
        String cuxiao = request.getParameter("cuxiao");
        if (pid==null ){
            //新增
            rs = ps.xinzeng(categoryId ,price,pname, mainImage
            ,stats,cuxiao);
        }else {
           //更新
            rs= ps.gengxin(pid,categoryId ,price,pname, mainImage
                    ,stats,cuxiao);
        }
        return rs;
    }
    //图片
}
