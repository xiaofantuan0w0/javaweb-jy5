package com.itdr.pojo;

public class Products {
 private Integer pid ;
 private String pname;
 private String mainImage;
 private Integer stats = 0;
 private String cuxiao ;
 private Integer categoryId;
 private Double price;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getStats() {
        return stats;
    }

    public void setStats(Integer stats) {
        this.stats = stats;
    }

    public String getCuxiao() {
        return cuxiao;
    }

    public void setCuxiao(String cuxiao) {
        this.cuxiao = cuxiao;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String a = "Pid:"+this.getPid()+
                ",CategoryId:"+this.getCategoryId()+
                ",MainImage:"+this.getMainImage()+
                ",Cuxiao:"+this.getCuxiao()+
                ",Pname:"+this.getPname()
                +",Price:"+this.getPrice()+
                ",Stats:"+this.getStats();
        return a;
    }
}
