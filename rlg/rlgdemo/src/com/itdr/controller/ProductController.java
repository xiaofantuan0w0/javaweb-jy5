package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PropertiesGetUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.geom.RectangularShape;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ProductController",value = "/manage/product/*")
@MultipartConfig
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
                rs = listDo(request,response);
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
            case "upload":
               rs = upload(request, response);
                break;
            default:
                rs = ResponseCode.defeats(PropertiesGetUtil.getstatus("CANTFAND_CODE"),
                        PropertiesGetUtil.getValue("CANTFAND_MSG"));
                break;
        }
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().println(JsonUtils.obj2String(rs));
//        response.setHeader("Content-type", "application/json;charset=UTF-8");
//        response.getWriter().write(rs.toString());
    }


    //用户列表
    private ResponseCode listDo(HttpServletRequest request,HttpServletResponse response) {
        String pageNum = request.getParameter("pageNum");
        String pageSize = request.getParameter("pageSize");
        rs = ps.selectAll(pageSize,pageNum);

        return rs;
//        request.setAttribute("pli",rs);
//        request.getRequestDispatcher("/WEB-INF/productlist.jsp").forward(request,response);
    }
    //用户搜索
    private ResponseCode searchDo(HttpServletRequest request) {
        String productName = request.getParameter("pname");
        String producId = request.getParameter("pid");
        rs = ps.selectOne(productName,producId);

        return rs;
    }
    //商品详情
    private ResponseCode detailDo(HttpServletRequest request) {
        String producId = request.getParameter("pid");
        rs = ps.detailOne(producId);

        return rs;
    }
    //用户上下架
    private ResponseCode setSale(HttpServletRequest request) {
        String status = request.getParameter("stats");
        String producId = request.getParameter("pid");
        rs = ps.setsale(status,producId);

        return rs;
    }
    //新增,更新产品
    private ResponseCode saveDo(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        String parentId = request.getParameter("parentId");
        String price = request.getParameter("price");
        String pname = request.getParameter("pname");
        String stats =request.getParameter("stats");
        if (pid==null ){
            //新增
            rs = ps.xinzeng(parentId ,price,pname,stats);
        }else {
           //更新
            rs= ps.gengxin(pid,parentId ,price,pname,stats);
        }
        return rs;
    }
    //图片
    private ResponseCode upload(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
       //获取上传的文件

        Part part = request.getPart("uping");
        String name = part.getHeader("content-disposition");

        //获取上传目录
        String root = "D:\\javaweb-jy5\\rlg\\rlgdemo\\web\\imgs\\productimgs";

        //获取后缀
        String str = name.substring(name.lastIndexOf("."),name.length()-1);

        //重写
        String filename = root +"\\"+UUID.randomUUID().toString()+str ;
        //放在类表里


        part.write(filename);
    //    request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request,response);
        return ResponseCode.success("成功");

    }
    //富文本图片上传
}
