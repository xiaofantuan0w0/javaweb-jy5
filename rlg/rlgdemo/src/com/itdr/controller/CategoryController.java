package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Categorys;
import com.itdr.service.CategoryService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "CategoryController",value = "/manage/category/*")
public class CategoryController extends HttpServlet {
    Categorys cat = new Categorys();
    ResponseCode rs = new ResponseCode();
    CategoryService cs = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResponseCode rs = null;
        String pathInfo = request.getPathInfo();
        String path = PathUtil.getPath(pathInfo);
        switch (path){
            case "get_category":
                rs = get_categoryDo(request);
                break;
            case "add_category":
                rs = add_categoryDo(request);
                break;
            case "set_category_name":
                rs = set_category_nameDo(request);
                break;
            case "get_deep_category":
                rs = get_deep_categoryDo(request);
                break;
            default:
                rs.setStatus(404);
                rs.setMag("请求错误，找不到网页");
                break;
        }
        response.getWriter().write(rs.toString());
    }
    //获得品类子节点
    private ResponseCode get_categoryDo(HttpServletRequest request) {
        String parentId = request.getParameter("categoryId");
        rs = cs.get_category(parentId);

        return rs;
    }
}
