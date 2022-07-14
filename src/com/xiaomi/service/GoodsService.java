package com.xiaomi.service;

import com.xiaomi.bean.Category;
import com.xiaomi.bean.Goods;
import com.xiaomi.dao.CategoryDao;
import com.xiaomi.dao.GoodsDao;
import com.xiaomi.utils.PageTool;

import java.util.List;

public class GoodsService {
    GoodsDao dao=new GoodsDao();
CategoryDao categoryDao=new CategoryDao();
    public PageTool<Goods> findAllGoods(String currentPage) {
        int totalSize=dao.findGoodsCount();
        PageTool<Goods>pt=new PageTool<>(currentPage,totalSize);
        List<Goods>goods=dao.findAllGoods(pt.getStartIndex(),pt.getPageSize());
        for(Goods goods1:goods)
        {
            Category category=categoryDao.findCategoryById(goods1.getCid()+"");
            goods1.setCategory(category);
        }
        pt.setResult(goods);
        return pt;
    }

    public boolean addGoods(Goods goods) {
        int row=dao.addGoods(goods);
        return row>0;
    }

    public boolean deleteGoodsById(String ids) {
        return dao.deleteGoodsById(ids)>0;
    }

    public Goods findGoodsById(String gid) {
        return dao.findGoodsById(gid);
    }

    public boolean updateGoodsById(Goods goods) {
        return dao.updateGoodsById(goods)>0;
    }


    public List<Goods> findGoodsByState(int count, int state) {
        return dao.findGoodsByState(count,state);
    }

    public List<Goods> findGoodsByCid(int count, int cid) {
        return dao.findGoodsByCid(count,cid);
    }

    public List<Goods> findGoodsByCookie(String search,int count) {
        return dao.findGoodsByCookie(search,count);
    }
}
