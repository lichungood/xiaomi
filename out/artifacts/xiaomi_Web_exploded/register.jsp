<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="css/index.css">
	<script src="js/jquery-3.3.1.js"></script>
</head>
<body>

<div class="sign_background">
    <div class="sign_background_in">
        <div class="sign_background_no1">
            <a href="index.jsp"><img src="img/logo.jpg" alt=""></a>
        </div>
        <div class="sign_background_no2">注册小米帐号</div>
		<center><span style="color: red " >${msg}</span></center>
        <div class="sign_background_no3">
               
            <div class="sign_background_no5">
             	
             	<form action="user" method="post" enctype="multipart/form-data">
					<input type="hidden" name="method" value="registerUser">
             	
             		<table style="width: 500px;" border="0" cellspacing="0">
             			<tr>
             				<td width="25%" class="_left">姓名：</td>
             				<td><input type="text" name="uname"><span id="uname_msg"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">性别：</td>
             				<td>
             					男<input type="radio" value="1" name="gender">
             				 	女<input type="radio" value="0" name="gender">
							</td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">电话号码：</td>
             				<td><input type="text" name="phone"><span id="phone_msg"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">所在地区：</td>
             				<td><input type="text" name="area"><span id="area_msg"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">账号：</td>
             				<td><input type="text" name="username"><span id="username_msg"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">密码：</td>
             				<td><input type="text" name="password"><span id="password_msg"></span></td>
             			</tr>
             			<tr>
             				<td width="25%" class="_left">上传头像：</td>
             				<td><input type="file" name="photo"></td>
             			</tr>
             		</table>
             		<div class="sign_background_no6" id="btn" onclick="sub()" >立即注册</div>
             	</form>
             	 
            </div>
        </div>
        <div class="sign_background_no7">注册帐号即表示您同意并愿意遵守小米 <span>用户协议</span>和<span>隐私政策</span> </div>
    </div>
    <div class="sign_background_no8"><img src="img/sign01.jpg" alt=""></div>

</div>
<script>
	$(function ()
	{//姓名不为空
		 $("[name='uname']").blur(function () {
			 var uname=$("[name='uname']").val();
			 if(uname==null||uname=="")
			 {
				 $("#uname_msg").text("用户名不能为空").css("color","red")
			 }
			 else
			 {
				 $("#uname_msg").text("√").css("color","red").css("color","green")
			 }
		 })
       //地区不为空
		$("[name='area']").blur(function () {
			var area=$("[name='area']").val();
			if(area==null||area=="")
			{
				$("#area_msg").text("用户名不能为空").css("color","red")
			}
			else
			{
				$("#area_msg").text("√").css("color","red").css("color","green")
			}
		})
         //密码不为空
         $("[name='password']").blur(function () {
			var password=$("[name='password']").val();
			if(password==null||password=="")
			{
				$("#password_msg").text("用户名不能为空").css("color","red")
			}
			else
			{
				$("#password_msg").text("√").css("color","red").css("color","green")
			}
		})
//手机号不为空，且唯一
         $("[name=phone]").blur(function () {
	     var phone=$(this).val();
	      if(phone==null||phone=="")
	    {
		    $("#phone_msg").text("手机号不能为空").css("color","red")
	      	$(this).focus();
		      return;
	     }

			if( !/^1[3456789]\d{9}$/.test(phone))//正则表达式验证手机号格式
			{$("#phone_msg").text("手机号格式不符合").css("color","red")
				$(this).focus();
			}
			else
			{
				$.ajax({
					url:"user",
					data:{"phone":phone,"method":"checkPhone"},
					dataType:"json",
					type:"post",
					success:function (res) {
						if(res)
						{
							$("#phone_msg").text("手机号已被注册").css("color","red")
							$(this).focus();
						}
						else
						{
							$("#phone_msg").text("√").css("color","green")
						}
					}

				})
			}
		 })
         //用户名不为空且唯一
		$("[name=username]").blur(function () {
			var username=$(this).val();
			if(username==null||username=="")
			{
				$("#username_msg").text("用户名不能为空").css("color","red")
				$(this).focus();
				//return ;

			}
			else
			{
				$.ajax({
					url:"user",
					type: "post",
					data: {"username":username,"method":"checkUsername"},
					dataType: "json",
					success:function (res)
					{
						if(res)
						{
							$("#username_msg").text("用户名已存在").css("color","red")
							$(this).focus();


						}
						else
						{
							$("#username_msg").text("√").css("color","red").css("color","green")
						}
					}
				})
			}
		})

	})



	//注册按钮
	function sub()
	{
		$("form").submit();
	}
</script>
</body>
</html>