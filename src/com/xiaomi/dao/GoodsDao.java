package com.xiaomi.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiaomi.bean.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    QueryRunner qr = new QueryRunner(new ComboPooledDataSource());

    /* CREATE TABLE `goods`
             (
             `gid` INT PRIMARY KEY AUTO_INCREMENT,
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
     `product_date` DATETIME,
     CONSTRAINT fk_goods_category FOREIGN KEY(cid) REFERENCES category(cid)
             );*/


    public int findGoodsCount() {


        Long totalSize = null;
        try {
            String sql = "select count(*) from goods";
            totalSize = (Long) qr.query(sql, new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalSize.intValue();
    }

    public List<Goods> findAllGoods(int startIndex, int pageSize) {
        List<Goods>goods= null;
        try {
            String sql="select * from goods limit ?,?";
            goods = qr.query(sql,new BeanListHandler<>(Goods.class),startIndex,pageSize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    public int addGoods(Goods goods) {
        int row= 0;
        try {
            String sql="insert into goods values (?,?,?,?,?,?,?,?,?,?,?,?)";
            row = qr.update(sql,null,goods.getCid(),goods.getGname(),goods.getColor(),
                    goods.getSize(),goods.getPrice(),goods.getDescription(),goods.getFull_description(),
                    goods.getPic(),goods.getState(),goods.getVersion(),goods.getProduct_date());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public int deleteGoodsById(String ids) {
        int row= 0;
        try {
            String sql="delete from goods where gid in ("+ids+")";
            row = qr.update(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public Goods findGoodsById(String gid) {
        Goods goods= null;
        try {
            String sql="select * from goods where gid=?";
            goods = qr.query(sql,new BeanHandler<>(Goods.class),gid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }
   /* sql,null,goods.getCid(),goods.getGname(),goods.getColor(),
            goods.getSize(),goods.getPrice(),goods.getDescription(),goods.getFull_description(),
            goods.getPic(),goods.getState(),goods.getVersion(),goods.getProduct_date());*/

    public int updateGoodsById(Goods goods) {
        int row= 0;
        try {
            String sql="update goods set cid=?,gname=?,color=?,size=?,price=?,description=?,full_description=?," +
                    "pic=?,state=?,version=?,product_date=? where gid=?";
            row = qr.update(sql,goods.getCid(),goods.getGname(),goods.getColor(),
                    goods.getSize(),goods.getPrice(),goods.getDescription(),goods.getFull_description(),
                    goods.getPic(),goods.getState(),goods.getVersion(),goods.getProduct_date(),goods.getGid());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return row;
    }

    public List<Goods> findGoodsByState(int count, int state) {
        List<Goods> goods = null;
        try {
            String sql="select * from goods where state=? limit ?";
            goods = qr.query(sql, new BeanListHandler<>(Goods.class), state, count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    public List<Goods> findGoodsByCid(int count, int cid) {
        List<Goods> goods = null;
        try {
            String sql="select * from goods where cid=? limit ?";
            goods = qr.query(sql, new BeanListHandler<>(Goods.class), cid, count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }
//mysql模糊查询'% %'
    public List<Goods> findGoodsByCookie(String search,int count) {
        //字符串拼接对象
        List<Goods> goods = null;
        try {
            StringBuilder sql=new StringBuilder();
            sql.append("select * from goods where ");
            if(!search.contains("#"))//一条记录
            {
                sql.append(" gname like '%"+search+"%'");
            }
            else {
                String[] split = search.split("#");

                for(int i=0;i<split.length;i++)
                {
                    if(i==0)
                    {
                        sql.append(" gname like '%"+split[i]+"%'");
                    }
                    else {
                        sql.append(" or gname like '%"+split[i]+"%'");
                    }
                }
            }
            sql.append(" limit "+count);
            goods = qr.query(sql.toString(), new BeanListHandler<>(Goods.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;

    }
}
