package com.itdr.pojo;

public class Categorys {
    private Integer id ;
    private Integer parentId;
    private String name;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ",MainImage:"+this.getName()+
                ",Cuxiao:"+this.getStatus()+
                ",Pname:"+this.getSortOrder()
                +",Price:"+this.getCreateTime()+
                ",Stats:"+this.getUpdateTime();
        return a;
    }
}
