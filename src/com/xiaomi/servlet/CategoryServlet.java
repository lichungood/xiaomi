package com.xiaomi.servlet;

import com.xiaomi.bean.Category;
import com.xiaomi.bean.User;
import com.xiaomi.service.CategoryService;
import com.xiaomi.utils.DateConverterUtils;
import com.xiaomi.utils.PageTool;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.Map;

@WebServlet("/cate")
public class CategoryServlet extends BaseServlet{
 CategoryService service=new CategoryService();
    public void findAllCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String currentPage=req.getParameter("currentPage");
        PageTool<Category>categories=service.findAllCategory(currentPage);
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("admin/category_list.jsp").forward(req,resp);

    }


    public void addCategory(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       Map<String,String[]>map=req.getParameterMap();

        Category category=new Category();
DateConverterUtils.convert();

       BeanUtils.populate(category,map);
        boolean flag=service.addCategory(category);

        if(flag)
        {
            resp.sendRedirect("cate?method=findAllCategory");
        }
        }

        public void deleteCategoryById(HttpServletRequest req,HttpServletResponse resp) throws IOException {
            String ids=req.getParameter("ids");
            System.out.println(ids);
            boolean flag=service.deleteCategoryById(ids);
            if(flag)
            {
                resp.sendRedirect("cate?method=findAllCategory");
            }
        }

    public void findCategoryById(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
      String cid=req.getParameter("cid");
      Category category=service.findCategoryById(cid);
      if(category!=null)
      {
          req.setAttribute("category",category);
          req.getRequestDispatcher("admin/category_update.jsp").forward(req,resp);
      }
    }


    public void updateCategory(HttpServletRequest req,HttpServletResponse resp) throws Exception {
       Map<String,String[]>map=req.getParameterMap();

       Category category=new Category();
       DateConverterUtils.convert();
       BeanUtils.populate(category,map);

       boolean flag=service.updateCategory(category);
       if(flag)
       {
           resp.sendRedirect("cate?method=findAllCategory");
       }

    }

}
