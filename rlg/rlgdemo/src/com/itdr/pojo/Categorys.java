package com.itdr.pojo;

public class Categorys {
    private Integer id ;
    private Integer parentId;
    private String categoryName;
    private String status;
    private Integer sortOrder;
    private String createTime;
    private String updateTime;

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

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        String a = "Pid:"+this.getId()+
                ",CategoryId:"+this.getParentId()+
                ",categoryName:"+this.getName()+
                ",status:"+this.getStatus()+
                ",sortorder:"+this.getSortOrder()
                +",greatTime:"+this.getCreateTime()+
                ",updatetime:"+this.getUpdateTime();
        return a;
    }
}
