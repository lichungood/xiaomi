package com.xiaomi.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaomi.bean.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
     QueryRunner qr=new QueryRunner(new ComboPooledDataSource());

    public int findCategoryCount() {
        Long totalSize= null;
        try {
            String sql="select count(*) from category";
            totalSize =(long) qr.query(sql,new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalSize.intValue();
    }



    public List<Category> findAllCategory(int startIndex, int pageSize) {
        List<Category>categories= null;
        try {
           String sql="select * from category limit ?,?";
            categories = qr.query(sql,new BeanListHandler<>(Category.class),startIndex,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    public int addCategory(Category category) {
        int row= 0;
        try {
            String sql="insert into category values (?,?,?,?,?,?)";
            row = qr.update(sql,null,category.getCname(),category.getState(),category.getOrder_number(),
                     category.getDescription(),category.getCreate_time());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }


    public int deleteCategoryById(String ids) {
        int row= 0;
        try {
            String sql="delete from category where cid in("+ids+")";
            row = qr.update(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public Category findCategoryById(String cid) {
        Category category= null;
        try {
            String sql="select * from category where cid=?";
            category = qr.query(sql,new BeanHandler<>(Category.class),cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    public int updateCategory(Category category) {
        int row= 0;
        try {
            String sql="update category set cname=?,state=?,order_number=?,description=?,create_time=? where cid=?";
            row = qr.update(sql,category.getCname(),category.getState(),category.getOrder_number(),
                    category.getDescription(),category.getCreate_time(),category.getCid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public List<Category> findAllCategory() {
        List<Category>categories= null;
        try {
            String sql="select * from category where state=1";
            categories = qr.query(sql,new BeanListHandler<>(Category.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
    public List<Category> findAllCategory(int count) {
        List<Category>categories= null;
        try {
            String sql="select * from category where state=1 order by order_number limit ?";
            categories = qr.query(sql,new BeanListHandler<>(Category.class),count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
