package com.xiaomi.service;

import com.xiaomi.bean.User;
import com.xiaomi.dao.UserDao;
import com.xiaomi.utils.PageTool;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserService {
    UserDao dao=new UserDao();
    public boolean checkPhone(HttpSession session,String phone) {
        User user=dao.checkPhone(phone);
        if(user!=null)
        {
            session.setAttribute("user",user);
            return true;
        }

        return false;
    }
    public boolean checkPhone(String phone) {
        User user=dao.checkPhone(phone);


        return user!=null;
    }

    public boolean checkUsername(String username) {
        User user=dao.checkUsername(username);
        return user!=null;
    }

    public boolean registerUser(User user) {
        int row=dao.registerUser(user);
        return row>0;
    }

    public boolean checkCode(HttpSession session, String code) {
        String sCode=(String)session.getAttribute("sCode");
        if(code.equalsIgnoreCase(sCode))
        {
            return true;
        }
        return false;
    }

    public boolean adminLogin(HttpSession session, String username, String password) {
        User user=dao.adminLogin(username,password);
        if(user!=null)
        {
            session.setAttribute("user",user);
            return true;
        }
        return false;
    }

    public PageTool<User> findAllUsers(String currentPage) {
        int totalSize=dao.userNum();
        PageTool<User>result=new PageTool<>(currentPage,totalSize);
        List<User> users=dao.findAllUsers(result.getStartIndex(),result.getPageSize());
        result.setResult(users);
        return result;
    }

    public boolean deleteUserById(String ids) {
        String[]  id = ids.split(",");
        int count = 0;
        for (int i =0; i< id.length; i++){
            int row =  dao.deleteUserById(id[i]);
            count = count + row;
        }
        return  count > 0;
    }
}
