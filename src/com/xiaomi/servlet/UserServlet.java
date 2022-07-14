package com.xiaomi.servlet;

import com.mchange.v2.beans.BeansUtils;
import com.xiaomi.bean.User;
import com.xiaomi.dao.UserDao;
import com.xiaomi.service.UserService;
import com.xiaomi.utils.PageTool;
import com.xiaomi.utils.UploadFile;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/user")
@MultipartConfig//文件上传配置
public class UserServlet extends BaseServlet{
UserService service=new UserService();

//检验手机号是否唯一
    public void checkPhone( HttpServletRequest req, HttpServletResponse resp) throws IOException {
String phone=req.getParameter("phone");

    boolean flag=service.checkPhone(phone);
    resp.getWriter().println(flag);
    }


    public void checkUsername( HttpServletRequest req, HttpServletResponse resp) throws IOException {
       String username=req.getParameter("username");
       boolean flag=service.checkUsername(username);
       resp.getWriter().println(flag);
    }

    public void registerUser( HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //拿到参数
       Map<String ,String[]> map=req.getParameterMap();
       User user=new User();
       //将数据存入user对象中
        BeanUtils.populate(user,map);
        //补充manager，create_time参数
        user.setManager(1);
        user.setCreate_time(new Date());
//头像

        Part part= req.getPart("photo");
        //判断上传
        if(part.getSize()==0)
        {req.setAttribute("msg","请上传头像");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        else
        {//进行上传
          String   photoName= UploadFile.uploadFile("register.jsp",part,req,resp);
            if("".equals(photoName))
            {
                req.setAttribute("msg","头像上传失败，请重新上传");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
                return;
            }
            //设置头像
            user.setPhoto(photoName);
        }

        boolean flag=service.registerUser(user);
        if(flag)
        {
            //成功重定向到登录页面
            resp.sendRedirect("login.jsp");
        }
        else
        {
            //显示注册失败
            req.setAttribute("msg","注册失败，请重新注册");
            //请求转发带着信息
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }

    }


    public void checkIsRegister( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String phone = req.getParameter("phone");
        HttpSession session = req.getSession();

        boolean flag = service.checkPhone(session,phone);
        if (!flag) {
           req.setAttribute("msg","手机号未注册");
           req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("index?method=indexInfo");
        }
    }
    public void checkCode( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
String code=req.getParameter("code");
       HttpSession session=req.getSession();
      boolean flag= service.checkCode(session,code);
      session.removeAttribute("sCode");
      resp.getWriter().println(flag);
    }

    public void adminLogin( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
       boolean flag= service.adminLogin(session,username,password);
       if(flag)
       {
           resp.sendRedirect("admin/main.jsp");
       }
       else {
           req.setAttribute("msg","用户名或密码不正确或您不是管理员");
           req.setAttribute("username",username);
           req.setAttribute("password",password);
           req.getRequestDispatcher("admin/login.jsp").forward(req,resp);
       }
    }


    public void  findAllUsers( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
String currentPage=req.getParameter("currentPage");
 PageTool<User>users= service.findAllUsers(currentPage);
       // List<User>users=dao.findAllUsers();
 req.setAttribute("users",users);
 req.getRequestDispatcher("admin/user_list.jsp").forward(req,resp);


        //System.out.println("test");
    }

    public void  deleteUserById( HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String ids = req.getParameter("ids");
        //调用service
        boolean flag = service.deleteUserById(ids);
        if(flag){
            String currentPage=req.getParameter("currentPage");
            PageTool<User>users= service.findAllUsers(currentPage);
            // List<User>users=dao.findAllUsers();
            req.setAttribute("users",users);
            req.getRequestDispatcher("admin/user_list.jsp").forward(req,resp);
          //  resp.sendRedirect("user?method=findAllUser");
        }
    }
}
