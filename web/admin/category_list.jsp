<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品分类</title>
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
	    	<li><a href="#">分类管理</a></li>
	    </ul>
    </div>
    <div class="rightinfo">
	    <div class="tools">
	    	<ul class="toolbar">
		        <li style="cursor: pointer;" onclick="add_category()"><span><img src="<%=basePath %>admin/images/t01.png"  /></span>添加类别</li>
		        <li style="cursor: pointer;" onclick="batchDelete()"><span><img src="<%=basePath %>admin/images/t03.png" /></span>批量删除</li>
	        </ul>
	    </div>
<%--		${categories}--%>
	    <table class="tablelist">
	    	<thead>
		    	<tr>
			        <th><input name="" type="checkbox" value="" checked="checked"/></th>
			        <th>序号<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></th>
			        <th>类别名称</th>
			        <th>启用状态</th>
			        <th>排序序号</th>
			        <th>创建时间</th>
			        <th>描述</th>
			        <th>操作</th>
		        </tr>
	        </thead>
	        <tbody>
<c:forEach items="${categories.result}" varStatus="i" var="category">
				<tr>
					<td><input name="chk" type="checkbox" value="${category.cid}" /></td>
					<td>${i.count}<i class="sort"><img src="<%=basePath %>admin/images/px.gif" /></i></td>
					<td>${category.cname}</td>
					<td>${category.state}</td>
					<td>${category.order_number}</td>
					<td><%--${category.create_time}--%>
						<fmt:formatDate value="${category.create_time}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
					</td>
					<td>${category.description}</td>
					<td>
						<a href="<%=basePath%>cate?method=findCategoryById&cid=${category.cid}">修改</a>
					</td>
				</tr>

</c:forEach>
	        </tbody>
	    </table>
		<div class="pagin">
			<div class="message">共<i class="blue">${categories.totalSize}</i>条记录，当前显示第&nbsp;<i class="blue">${categories.currentPage}</i>页</div>
			<ul class="paginList">
				<li class="paginItem"><a href="<%=basePath%>cate?method=findAllCategory&currentPage=1">首页</a></li>
				<li class="paginItem"><a href="<%=basePath%>cate?method=findAllCategory&currentPage=${categories.prePage}">上一页</a></li>
				<li class="paginItem"><a href="<%=basePath%>cate?method=findAllCategory&currentPage=${categories.nextPage}">下一页</a></li>
				<li class="paginItem"><a href="<%=basePath%>cate?method=findAllCategory&currentPage=${categories.totalPages}">尾页</a></li>
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
	function batchDelete()
	{var ids=""
		var arr=$("[name=chk]:checked")
		$(arr).each(function ()
		{
			var id=$(this).val();
			ids=","+id+ids;

		})
		console.log(ids)
		if(ids=="")
		{
			alert("请先勾选")
			return;
		}
		else
		{
			ids=ids.substring(1);
		}
		if(confirm("确认删除吗"))
		{
			location.href="cate?method=deleteCategoryById&ids="+ids;
		}

	}
	function add_category()
	{
		location.href="admin/category_add.jsp";
	}
</script>
</body>
</html>
