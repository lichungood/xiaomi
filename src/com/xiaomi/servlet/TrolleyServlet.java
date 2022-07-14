package com.xiaomi.servlet;

import com.xiaomi.bean.Trolley;
import com.xiaomi.bean.User;
import com.xiaomi.service.TrolleyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/trolley")
public class TrolleyServlet extends BaseServlet {
    TrolleyService service = new TrolleyService();

    //添加购物车
    public void addTrolley(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String gid = req.getParameter("gid");
        User user = (User) req.getSession().getAttribute("user");
        // System.out.println(gid);
        //System.out.println(user);
        //补充参数
        Trolley trolley = new Trolley();
        trolley.setGid(Integer.parseInt(gid));//gid
        trolley.setUid(user.getUid());//uid
        //调用添加方法
        boolean flag = service.addTrolley(trolley);
        resp.getWriter().println(flag);

    }


    public void getTrolleyCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User)req.getSession().getAttribute("user");
        int num = service.getTrolleyCount(user.getUid());
        resp.getWriter().println(num + "");

    }

    public void findAllTrolley(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user=(User)req.getSession().getAttribute("user");
        List<Trolley>trolleys=service.findAllTrolley(user);
        if(trolleys!=null)
        {
            req.setAttribute("trolleys",trolleys);
            req.getRequestDispatcher("trolley.jsp").forward(req,resp);
        }

    }

    public void updateTrolleyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tid=req.getParameter("tid");
        String number=req.getParameter("number");
        System.out.println(tid+"----"+number);
        boolean flag=service.updateTrolleyById(tid,number);
        if(flag)
        {
            resp.sendRedirect("trolley?method=findAllTrolley");
        }

    }

    public void delTrolleyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tid=req.getParameter("tid");
        boolean flag=service.delTrolleyById(tid);
        if(flag)
        {
            resp.sendRedirect("trolley?method=findAllTrolley");
        }
    }
}
