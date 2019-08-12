package com.itdr.pojo;

public class Products {
 private Integer pid ;
 private String pname;
 private String mainImage;
 //下架设计 0  上架 1
 private Integer stats = 0;
 private Integer parentId;
 private String price;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    @Override
//    public String toString() {
//        return  "{"+
//                "pid:"+pid+
//                ",pname:"+pname+
//                ",mainImage:"+mainImage+
//                ",cuxiao:"+cuxiao+
//                ",price:"+price+
//                ",stats:"+stats+"\'"
//                +"}";
//
//
//    }
}
