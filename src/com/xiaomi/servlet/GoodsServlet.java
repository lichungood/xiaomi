package com.xiaomi.servlet;

import com.mchange.v2.beans.BeansUtils;
import com.xiaomi.bean.Category;
import com.xiaomi.bean.Goods;
import com.xiaomi.service.CategoryService;
import com.xiaomi.service.GoodsService;
import com.xiaomi.utils.DateConverterUtils;
import com.xiaomi.utils.PageTool;
import com.xiaomi.utils.UploadFile;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/goods")
@MultipartConfig
public class GoodsServlet extends BaseServlet {
  private   CategoryService categoryService = new CategoryService();
  private   GoodsService service = new GoodsService();

    public void findAllCategory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();

        req.setAttribute("categories", categories);
        req.getRequestDispatcher("admin/goods_add.jsp").forward(req, resp);

    }


    public void findAllGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage=req.getParameter("currentPage");
        PageTool<Goods>pt=service.findAllGoods(currentPage);
        req.setAttribute("pt",pt);
        req.getRequestDispatcher("admin/goods_list.jsp").forward(req,resp);

    }
    public void addGoods(HttpServletRequest req,HttpServletResponse resp) throws Exception
    {
        Map<String,String[]>map=req.getParameterMap();
        Goods goods=new Goods();
       DateConverterUtils.convert();
        BeanUtils.populate(goods,map);

        //获取part对象
        Part part=req.getPart("pic");
        //判断是否有上传的内容
        if(part.getSize() == 0){
            req.setAttribute("msg","请上传商品图片");
            findAllCategory(req,resp);
            return; //结束方法，下边的代码不再执行
        }else{
            //有上传内容
            String picName = UploadFile.uploadFile("goods?method=findAllCategory",part,req,resp);
            if("".equals(picName)){
                return;
            }
            goods.setPic(picName);
        }


        //调用service
        boolean flag = service.addGoods(goods);
        if(flag){
            /*System.out.println("success");*/
            resp.sendRedirect("goods?method=findAllCategory");
        }
    }

    public void deleteGoodsById(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String ids=req.getParameter("ids");
        boolean flag=service.deleteGoodsById(ids);
        if(flag)
        {
            resp.sendRedirect("goods?method=findAllGoods");
        }
    }
    public void findGoodsById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String gid=req.getParameter("gid");
        Goods goods=service.findGoodsById(gid);
        if(goods!=null)
        {
            List<Category> categories = categoryService.findAllCategory();

            req.setAttribute("categories", categories);
            req.setAttribute("goods",goods);
            req.getRequestDispatcher("admin/goods_update.jsp").forward(req, resp);

        }

    }


    public void updateGoodsById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Map<String, String[]> map = req.getParameterMap();
        Goods goods=new Goods();
        DateConverterUtils.convert();
        BeanUtils.populate(goods,map);


        String picName="";
        Part part=req.getPart("pic");
        if(part.getSize()==0)
        {picName=req.getParameter("oldPic");

        }
        else {
            picName = UploadFile.uploadFile("goods?method=findGoodsById", part, req, resp);
              if(picName.equals(""))
              {
                  return;
              }
        }
        goods.setPic(picName);
        boolean flag=service.updateGoodsById(goods);
        if(flag)
        {
            resp.sendRedirect("goods?method=findAllGoods");
        }
    }

}
