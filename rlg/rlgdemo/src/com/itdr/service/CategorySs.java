package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.CategoryDao;
import com.itdr.pojo.Categorys;

import java.util.ArrayList;
import java.util.List;

public class CategorySs {
    CategoryDao cd = new CategoryDao();
    public ResponseCode get_deep_categoryDo(String parentId) {
        Integer pid = Integer.parseInt(parentId);
        List<Categorys> li = new ArrayList<>();

        getAll(pid,li);
        return ResponseCode.success(li);
    }
    private void getAll(Integer pid ,List<Categorys> li){
        List<Categorys> list = cd.get_deep_categoryDo(pid);
        if(list !=null && list.size() !=0){
            for (Categorys cate:list){
                li.add(cate);
                getAll(cate.getId(),li);
            }
        }

    }
}
