package com.xiaomi.bean;

import java.util.Date;

public class Goods {
    /*`gid` INT PRIMARY KEY AUTO_INCREMENT,
	`cid` INT,
            `gname` VARCHAR(50) NOT NULL,
	`color` VARCHAR(50),
	`size` VARCHAR(50),
	`price` DOUBLE NOT NULL,
            `description` VARCHAR(500),
	`full_description` VARCHAR(1000),
	`pic` VARCHAR(200),
	`state` INT DEFAULT 0,
            `version` VARCHAR(50),
	`product_date` DATETIME,*/

    private  int gid;//商品编号
    private int cid;
    private String gname;//名称
    private String color;//颜色
    private String size;//尺寸
    private double price;//价格
    private String description;//简介
    private String full_description;//详细描述
    private String pic;//图片
    private int state;//是否上架
    private String version;//型号
    private Date product_date;//上架日期
    private Category category;//类别

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Goods() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getProduct_date() {
        return product_date;
    }

    public void setProduct_date(Date product_date) {
        this.product_date = product_date;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", cid=" + cid +
                ", gname='" + gname + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", version='" + version + '\'' +
                ", product_date=" + product_date +
                ", category=" + category +
                '}';
    }
}
