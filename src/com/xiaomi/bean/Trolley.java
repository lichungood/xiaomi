package com.xiaomi.bean;

public class Trolley {
    /*tid INT PRIMARY KEY AUTO_INCREMENT,#主键
    uid INT,#关联用户的id
    gid INT,#关联商品的id
    number INT,#绑定商品的数量
    orders_number VARCHAR(100) DEFAULT NULL#订单编号*/
    private int tid;
    private int uid;
    private int gid;
    private int number;
    private String orders_number;
    private Goods goods;
    private User user;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trolley() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOrders_number() {
        return orders_number;
    }

    public void setOrders_number(String orders_number) {
        this.orders_number = orders_number;
    }

    @Override
    public String toString() {
        return "Trolley{" +
                "tid=" + tid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", number=" + number +
                ", orders_number='" + orders_number + '\'' +
                ", goods=" + goods +
                ", user=" + user +
                '}';
    }
}
