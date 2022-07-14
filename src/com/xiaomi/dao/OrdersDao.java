package com.xiaomi.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaomi.bean.Orders;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class OrdersDao {
    private QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    public int insertOrders(Orders orders) {
        int row = 0;
        try {
            String sql="insert into orders values (?,?,?,?,?,?,?)";
            row = qr.update(sql, orders.getOrders_number(), orders.getUid(), orders.getSumPrice(),
                    orders.getGoodsCount(),orders.getOrdersName(), orders.getCreate_time(),0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
