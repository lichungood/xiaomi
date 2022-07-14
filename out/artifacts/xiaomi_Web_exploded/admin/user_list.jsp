<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	
	//获取项目名
	String path = request.getContextPath();
	//获取tomcat 协议+地址+端口号+ 获取项目名
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String photoPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/xiaomipic/";
%>

<!DOCTYPE html >
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户信息</title>
<link href="<%=basePath %>admin/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath %>js/jquery-3.3.1.js"></script>

<script type="text/javascript">


// old write 
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});


</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">商品管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        
        <!-- 
        
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t04.png" /></span>统计</li>
         -->
        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %>admin/images/t03.png" /></span>批量删除</li>
        </ul>

    </div>
        <%--${users}--%>
    <table class="tablelist">
    	<thead>
	    	<tr><th><input name="" type="checkbox" value="" checked="checked" /></th>
                <th>序号<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></th>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>电话号码</th>
	        <th>所在地区</th>
	        <th>权限</th>
	        <th>账号</th>
	       	<th>头像</th>
	       	<th>注册时间</th>
	       	<th>操作</th>
	        </tr>
	        </thead>
        <tbody>
        <c:forEach items="${users.result}" var="user" varStatus="i">
            <tr>
                <td><input name="chk" type="checkbox" value="${user.uid}" /></td>
                <td>${i.count}<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></td>
                <td>${user.uname}</td>
                <td>
                    <c:if test="${user.gender==1}">男</c:if>
                    <c:if test="${user.gender==0}">女</c:if>
               </td>
                <td>${user.phone}</td>
                <td>${user.area}</td>
                <td>
                    <c:if test="${user.manager==1}">普通用户</c:if>
                    <c:if test="${user.manager==0}">管理员</c:if>
                </td>
                <td>${user.username}</td>

                <<td><img src="<%=photoPath%>${user.photo}" width="50px"> </td>
                <td>${user.create_time}</td>


            </tr>
        </c:forEach>

        	
        </tbody>
    </table>
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${users.totalSize }</i>条记录，当前显示第&nbsp;<i class="blue">${users.currentPage}&nbsp;</i>页</div>
        <ul class="paginList">
	        
	         <li class="paginItem"><a href="<%=basePath%>user?method=findAllUsers&currentPage=1">首页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>user?method=findAllUsers&currentPage=${users.prePage }">上一页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>user?method=findAllUsers&currentPage=${users.nextPage }">下一页</a></li>
	         <li class="paginItem"><a href="<%=basePath%>user?method=findAllUsers&currentPage=${users.totalPages }">尾页</a></li>
	         
	        
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');


	</script>
<script>
    function batchDelete() {
        //用于拼接勾选的复选框的value
        var ids = "";
        //获取勾选的复选框
        var arr = $("[name=chk]:checked");
        //遍历arr ，获取每个勾选的复选框的value值
        $(arr).each(function () {
            var id = $(this).val();
            ids = "," + id+ids;
        })
        if(ids == ""){
            alert("请先勾选要删除的选项")
            return; //结束，不在请求后台
        }else{
            ids = ids.substring(1);
        }
        if(confirm("确认删除吗？")){
            location.href="user?method=deleteUserById&ids="+ids;
        }
    }
</script>
</body>
</html>
