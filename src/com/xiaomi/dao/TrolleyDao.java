package com.xiaomi.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaomi.bean.Trolley;
import com.xiaomi.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class TrolleyDao {
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    public Trolley findTrolley(Trolley trolley) {
        Trolley t= null;
        try {
            String sql="select * from trolley where uid=? and gid=? and orders_number is null";
            t = qr.query(sql,new BeanHandler<>(Trolley.class),trolley.getUid(),trolley.getGid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    public int updateTrolley(Trolley trolley) {
        int row= 0;
        try {
            String sql="update trolley set number=? where tid=? and orders_number is null";
            row = qr.update(sql,trolley.getNumber(),trolley.getTid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public int addTrolley(Trolley trolley) {
        int row= 0;
        try {
            String sql="insert into trolley values (?,?,?,?,?)";
            row = qr.update(sql,null,trolley.getUid(),trolley.getGid(),trolley.getNumber(),trolley.getOrders_number());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public int getTrolleyCount(int uid) {
        Long num= null;
        try {
            String sql="select count(*) from trolley  where uid=? and orders_number is null";
            num = (Long) qr.query(sql,new ScalarHandler(),uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return num.intValue();

    }

    public List<Trolley> findAllTrolley(User user) {
        List<Trolley> trolleys = null;
        try {
            String sql="select * from trolley where uid=? and orders_number is null";
            trolleys = qr.query(sql, new BeanListHandler<>(Trolley.class), user.getUid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trolleys;
    }

    public int updateTrolleyById(String tid, String number) {
        int row = 0;
        try {
            String sql="update trolley set  number=? where tid=? and orders_number is null";
            row = qr.update(sql, number, tid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public int delTrolleyById(String tid) {
        int row= 0;
        try {
            String sql="delete from trolley where tid=? and orders_number is null";
            row = qr.update(sql,tid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public int updateTrolleyByUId(int uid, String orders_number) {
        int row = 0;
        try {
            String sql="update trolley set orders_number=? where uid=? and orders_number is null";
            row = qr.update(sql, orders_number,uid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }
}
