package com.xiaomi.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaomi.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
    public User checkPhone(String phone) {
        User user= null;
        try {
            String sql="select * from user where phone=?";
            user = qr.query(sql,new BeanHandler<>(User.class),phone);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public User checkUsername(String username) {
        User user= null;
        try {
            String sql="select * from user where username=?";
            user = qr.query(sql,new BeanHandler<>(User.class),username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public int registerUser(User user) {
        int row= 0;
        try {
            String sql="insert into user values (?,?,?,?,?,?,?,?,?,?)";
            row = qr.update(sql,null,user.getUname(),user.getGender(),user.getPhone(),user.getArea(),user.getManager(),
                    user.getUsername(),user.getPassword(),user.getPhoto(),user.getCreate_time());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public User adminLogin(String username, String password) {
        User user= null;
        try {
            String sql="select * from user where username=? and password=? and manager=?";
            user = qr.query(sql,new BeanHandler<>(User.class),username,password,0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> findAllUsers(int startIndex,int pageSize) {
        List<User>users= null;
        try {
            String sql="select * from user limit ?,?";
            users = qr.query(sql,new BeanListHandler<>(User.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public int userNum() {
        Long num= null;
        try {
            String sql="select count(*) from user";
            num = (long)  qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return num.intValue();
    }

    public int deleteUserById(String id) {
        int row = 0;
        try {
            String sql = "delete from user where uid = ?";
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

}
