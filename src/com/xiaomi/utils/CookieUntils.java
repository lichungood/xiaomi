package com.xiaomi.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUntils {
    public static void addCookie(String search, HttpServletResponse resp,HttpServletRequest req)
    {
        //搜索的值只保留三个，利用特殊符号拼接
        String info=getCookieInfo(req);
        if(info.equals(""))//原来没有值
        {
            info=search;
        }
        else {

            // 新值如果重复不要
            if(!info.contains(search))
            {
                boolean isContains=info.contains("#");
                if(isContains)
                {
                    String[] split = info.split("#");
                    if(split.length==3)//等于三长度就将第一个去掉加入新的
                    {
                        info=split[1]+"#"+split[2];
                    }
                }
                info=info+"#"+search;
            }

        }

        Cookie cookie=new Cookie("search",info);
        resp.addCookie(cookie);

    }
    public  static String getCookieInfo(HttpServletRequest req)
    {//获得之前cookie的值
        String info="";
        Cookie[] cookies = req.getCookies();
        if(cookies!=null||cookies.length!=0)
        {//在所有cookie中拿到search这个cookie
            for(Cookie cookie:cookies)
            {
                if("search".equals(cookie.getName()))
                {
                    info=cookie.getValue();
                }
            }
        }
        return  info;
    }
}
