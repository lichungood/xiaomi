package com.xiaomi.bean;

import java.util.Date;
import java.util.List;

public class Orders {
  /*  orders_number  VARCHAR(100)  utf8_general_ci  NO      PRI     (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    uid            INT(11)       (NULL)           NO              (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    sumPrice       DOUBLE        (NULL)           NO              (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    goodsCount     INT(11)       (NULL)           NO              (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    ordersName     VARCHAR(100)  utf8_general_ci  NO              (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    create_time    DATETIME      (NULL)           NO              (NULL)           SELECT,INSERT,UPDATE,REFERENCES
    state          INT(11)*/
    private String orders_number;
    private int uid;
    private double sumPrice;
    private int goodsCount;
    private String ordersName;
    private Date create_time;
    private int state;
    private User user;
    private List<Trolley>trolleys;

    public Orders() {
    }

    public String getOrders_number() {
        return orders_number;
    }

    public void setOrders_number(String orders_number) {
        this.orders_number = orders_number;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getOrdersName() {
        return ordersName;
    }

    public void setOrdersName(String ordersName) {
        this.ordersName = ordersName;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Trolley> getTrolleys() {
        return trolleys;
    }

    public void setTrolleys(List<Trolley> trolleys) {
        this.trolleys = trolleys;
    }

    public Orders(String orders_number, int uid, double sumPrice, int goodsCount, String ordersName, Date create_time) {
        this.orders_number = orders_number;
        this.uid = uid;
        this.sumPrice = sumPrice;
        this.goodsCount = goodsCount;
        this.ordersName = ordersName;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders_number='" + orders_number + '\'' +
                ", uid=" + uid +
                ", sumPrice=" + sumPrice +
                ", goodsCount=" + goodsCount +
                ", ordersName='" + ordersName + '\'' +
                ", create_time=" + create_time +
                ", state=" + state +
                ", user=" + user +
                ", trolleys=" + trolleys +
                '}';
    }
}
