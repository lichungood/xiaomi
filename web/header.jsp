<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //获取项目名
    String path = request.getContextPath();
    //获取tomcat 协议+地址+端口号+ 获取项目名
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    //获取tomcat 协议+地址+端口号
    String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/xiaomipic/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div class="box">
      <div class="inner whiteGL">
          <div class="left">
              <a class="mix" href="">仿小米商城-学习专用</a>
          </div>
          <div class="right">
              <c:if test="${user==null}">
                  <a class="mix" href="login.jsp">登录</a>
                  <a href="register.jsp">注册</a>
                  <a class="max"  href="">消息通知</a>
                  <a href="trolley.html"><img src="img/cart.jpg" alt=""></a>
              </c:if>
              <c:if test="${user!=null}">
                  <a class="mix" href="login.jsp">欢迎</a>
                  <a href="register.jsp">${user.uname}</a>
                  <a class="max"  href="">登录</a>
                  <a href="javascript:void(0);" onclick="findAllGoodsTrolley()">购物车(<span id="trolleyNumber">0</span>)</a>
              </c:if>
          </div>
      </div>
  </div>
  <div class="logo">
      <div class="logo_left">
          <div>
              <a href="javascript:void(0);" title="小米官网"><img class="xiaomi" src="img/logo.jpg"></a>
          </div>
      </div>
      <ul class="logo_center orangeGL">
          <a href="">小米手机</a>
          <a href="">红米</a>
          <a href="">笔记本</a>
          <a href="">电视</a>
          <a href="">盒子</a>
          <a href="">新品</a>
          <a href="">路由器</a>
          <a href="">智能硬件</a>
          <a href="">服务</a>
          <a href="">社区</a>
      </ul>
      <form class="logo_right" >

         <div class="logo_input"><input type="text" name="search">
             <div class="logo_input_div"></div>
         </div>
          <a class="logo_right_a"><img src="img/find.jpg"></a>
      </form>
  </div>
<script src="js/jquery-3.3.1.js"></script>
<script >

    //页面加载执行，ajax获取购物车条数
    var user="${user}";
    if(user!=null&&user!="")
    {
        $.ajax({
            url: "trolley",
            type:"post",
            dataType: "text",
            data:{"method":"getTrolleyCount"},
            success:function (num)
            {
                $("#trolleyNumber").text(num);
            }
        })
    }
//点击购物车到购物车页面，并列出所有物品
  function  findAllGoodsTrolley()
    {
        if(user==null&&user=="")
        {
            alert("您尚未登陆，不能查看购物车，请先登录")
            location.href="login.jsp";
        }
        else
        {
location.href="<%=basePath%>trolley?method=findAllTrolley";
        }
    }
    //根据搜索进行为你推荐的内容
    $(".logo_right").click(function () {
       var search=$("[name=search]").val();
         console.log(search);
         if(search==null||search=="")
         {
             alert("请输入搜索内容");
             return;
         }
         else
         {
            $.ajax({
                url:"index",
                type:"post",
                dataType:"json",
                data:{"search":search,"method":"searchGoods"},
                success:function (res)
                {
                    if(res)
                    {
                        alert("保存成功");
                    }
                }
            })
         }
    })




</script>
</body>
</html>