package com.itdr.pojo;

public class Categorys {
    private Integer id ;
    private Integer parentId;
    private String categoryName;
    private String status;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


//    @Override
//    public String toString() {
//        return "{"+
//                "id:"+id+
//                ",parentId:"+parentId+
//                ",status:"+status+
//                ",sortOrder:"+sortOrder+
//                ",categoryName:"+categoryName+"\'"+
//                "}";
//    }
}
