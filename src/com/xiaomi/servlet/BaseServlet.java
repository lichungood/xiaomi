package com.xiaomi.servlet;

import javax.servlet.ServletException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
public class BaseServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //请求和响应中文不乱码
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            //获取请求参数
            String method = req.getParameter("method");
            //通过反射技术实现方法的调用，省略if的判断
            Class<? extends BaseServlet> aClass = this.getClass();
            Method me = aClass.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            me.invoke(this,req,resp);  //执行me表示的方法，即需求要调用的方法
        } catch (Exception e) {
            System.out.println("exception");
        }

    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
