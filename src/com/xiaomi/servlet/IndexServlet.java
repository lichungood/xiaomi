package com.xiaomi.servlet;

import com.xiaomi.bean.Category;
import com.xiaomi.bean.Goods;
import com.xiaomi.service.CategoryService;
import com.xiaomi.service.GoodsService;
import com.xiaomi.utils.CookieUntils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends BaseServlet{
CategoryService categoryService=new CategoryService();
GoodsService goodsService=new GoodsService();

    public void indexInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //商品分类展示，只显示前10个
        List<Category>categories= categoryService.findAllCategory(10);
        //小米明星单品,仅限5条，分类为state=4
        List<Goods>goodsStar=goodsService.findGoodsByState(5,4);
        //家电，仅限8条，cid为7
        List<Goods>goodsJD=goodsService.findGoodsByCid(8,7);
        //智能分类，仅限10，cid=8
        List<Goods>goodsZN=goodsService.findGoodsByCid(10,8);
        //热门产品，仅限4，state=1
        List<Goods>hotGoods=goodsService.findGoodsByState(4,1);
        //为你推荐，根据cookie内容进行推荐,仅限5条
       String search= CookieUntils.getCookieInfo(req);
       List<Goods>goodsTJ=null;
       if(search.equals(""))//为空则为为你推荐state=2
       {
           goodsTJ=goodsService.findGoodsByState(5,2);

       }//cookie中有内容
       else {
           goodsTJ=goodsService.findGoodsByCookie(search,5);
       }

        req.setAttribute("categories",categories);
        req.setAttribute("goodsStar",goodsStar);
        req.setAttribute("goodsJD",goodsJD);
        req.setAttribute("goodsZN",goodsZN);
        req.setAttribute("hotGoods",hotGoods);
        req.setAttribute("goodsTJ",goodsTJ);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }



    public void searchGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search=req.getParameter("search");
       System.out.println(search);
        CookieUntils.addCookie(search,resp,req);
resp.getWriter().println(true);
    }

    public void findGoodsDetailById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String gid=req.getParameter("gid");
       Goods goods=goodsService.findGoodsById(gid);
       req.setAttribute("goods",goods);
       req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
