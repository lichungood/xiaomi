package com.xiaomi.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*
 * 上传图片到的工具类
 * */
public class UploadFile {
    public static  String uploadFile(String error,Part part, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String fileName="";
        //获取上传文件的名称
        fileName = part.getSubmittedFileName();
        fileName = UUID.randomUUID()+fileName;
        //判断是否是图片类型
        String type = fileName.substring(fileName.lastIndexOf(".")+1);
        if(!("png".equals(type) || "jpg".equals(type) || "jpeg".equals(type))){
            req.setAttribute("msg","图片类型必须是：png/jpg/jpeg类型");
            req.getRequestDispatcher(error).forward(req,resp);
            return "";
        }
        String path = "D:\\JavaProject\\xiaomipic";
        //创建file对象，确定path是否存在，不存在创建目录，存在不需要创建，直接使用
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //上传
        part.write(path+"\\"+fileName);
        return fileName;

    }
}
