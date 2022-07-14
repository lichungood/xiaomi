package com.xiaomi.servlet;

import com.xiaomi.bean.Orders;
import com.xiaomi.bean.User;
import com.xiaomi.service.OrdersService;
import com.xiaomi.service.TrolleyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/orders")
public class OrdersServlet extends BaseServlet{
    private OrdersService service=new OrdersService();
    private TrolleyService trolleyService=new TrolleyService();
    //生成订单
    public void insertOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String sumPrice=req.getParameter("sumPrice");
        String goodsCount=req.getParameter("goodsCount");
        //补充参数
        HttpSession session = req.getSession();
        User user=(User) session.getAttribute("user");
        String ordersName=user.getUname()+"的订单";
       // Date create_time=new Date();
        int uid= user.getUid();
        String orders_number= UUID.randomUUID().toString();
        Orders orders=new Orders(orders_number,uid,Double.valueOf(sumPrice),Integer.valueOf(goodsCount),ordersName,new Date());
        boolean flag=service.insertOrders(orders);
        if(flag)
        {
            System.out.println("订单生成成功！");
        }
        //修改购物车信息
        boolean isSuccess=trolleyService.updateTrolleyByUId(uid,orders_number);
        if(isSuccess)
        {
            System.out.println("购物车修改成功");
            session.setAttribute("orders",orders);
            resp.sendRedirect("pay");
        }
    }
}
