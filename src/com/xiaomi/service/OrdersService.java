package com.xiaomi.service;

import com.xiaomi.bean.Orders;
import com.xiaomi.dao.OrdersDao;

public class OrdersService {
    private OrdersDao dao=new OrdersDao();

    public boolean insertOrders(Orders orders) {
        return dao.insertOrders(orders)>0;
    }
}
