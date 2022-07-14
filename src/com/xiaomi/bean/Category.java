package com.xiaomi.bean;

import java.util.Date;

public class Category {
   /* `cid` INT(11) NOT NULL AUTO_INCREMENT,
  `cname` VARCHAR(30) NOT NULL,
  `state` INT(11) DEFAULT '1',
            `order_number` INT(11) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `create_time` DATETIME DEFAULT NULL,*/
    private int cid;
    private String cname;
    private int state;
    private int order_number;
    private String description;
    private Date create_time;

    public Category() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", state=" + state +
                ", order_number=" + order_number +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
