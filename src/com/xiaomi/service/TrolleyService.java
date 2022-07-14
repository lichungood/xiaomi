package com.xiaomi.service;

import com.xiaomi.bean.Goods;
import com.xiaomi.bean.Trolley;
import com.xiaomi.bean.User;
import com.xiaomi.dao.GoodsDao;
import com.xiaomi.dao.TrolleyDao;

import java.util.List;

public class TrolleyService {
    TrolleyDao dao=new TrolleyDao();
    GoodsDao goodsDao=new GoodsDao();
//判断一下number是否有值，有就将number+1，更新到数据库中
    //没有就将number设置为1，数据插入到数据库中
    public boolean addTrolley(Trolley trolley) {
        Trolley t=dao.findTrolley(trolley);
        if(t!=null)//number有值
        {
            t.setNumber(t.getNumber()+1);
           int row= dao.updateTrolley(t);
           return true;
        }
        else {
            trolley.setNumber(1);
            int row=dao.addTrolley(trolley);
            return false;
        }

    }

    public int getTrolleyCount(int uid) {
        return dao.getTrolleyCount(uid);
    }

    public List<Trolley> findAllTrolley(User user) {
        List<Trolley>trolleys=dao.findAllTrolley(user);
        for(Trolley trolley:trolleys)
        {Goods goods=goodsDao.findGoodsById(trolley.getGid()+"");
            trolley.setGoods(goods);
            trolley.setUser(user);
        }
        return trolleys;
    }

    public boolean updateTrolleyById(String tid, String number) {
        return dao.updateTrolleyById(tid,number)>0;
    }

    public boolean delTrolleyById(String tid) {
        return dao.delTrolleyById(tid)>0;
    }

    public boolean updateTrolleyByUId(int uid, String orders_number) {
        return dao.updateTrolleyByUId(uid,orders_number)>0;
    }
}
