<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path=request.getScheme()+"://"+request.getServerName()+":"+
            request.getServerPort()+request.getContextPath()+"/";
    pageContext.setAttribute("path", path);
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery.1.11.1.min.js"></script>

</head>
<body>
<div class="register_head_on">

</div>
<div class="register_head">
    <a href="index.html"><img src="img/logo.jpg" alt=""></a>
    <div class="register_head_right">
        <p class="register_head_right_p1">小 米 商 城</p>
        <p class="register_head_right_p2">让每个人都享受科技乐趣</p>
    </div>

</div>

<div class="register">
    <div class="register_boby">
        <div class="register_boby_min">
            <div class="register_boby_no1">
                <div class="register_boby_no1_in">
                    <span style="color: #ff6700">手机验证码登录 </span>
                </div>
            </div>
            <form id="f3" action="user" method="post">
            
            <!-- fs区分的方法 -->
            <input name="method" value="checkIsRegister" type="hidden">
            
            <div class="register_boby_no2">
            	<span id="msg" style="color: red;font-size: 12px;margin-left: 20px;">${msg}</span>
                <input id="phone" name="phone" type="text" placeholder="手机号码">
                
                <input name="code"  type="text" placeholder="输入验证码" style="width: 200px; margin-left: 15px;float: left;">
                <img id="code" class="code_images"  src="${path}vs" onclick="changeVerify(this)"  style="margin-top:10px;width: 138px;float: left;height: 50px;margin-left: 5px; " />
                <div style="clear: both;">
                
                <div class="register_boby_no2_div">
                    <span id="sub">登录</span>
                </div>
            </div>
            </div>
            </form>
            <div class="register_boby_no3">
                <a href="javascript:void(0);" style="color: #ff6700">账号密码登录</a>
                <sapn class="register_boby_no3_span">
                    <a href="register.jsp">立即注册</a>
                    <span>|</span>
                    <a href="avascript:void(0);">忘记密码?</a>
                </sapn>

            </div>
            <div class="register_boby_no4">
                <img src="img/register02.jpg" alt="">
            </div>

        </div>
    </div>
</div>
<div class="register_foot">
    <img  src="img/register03.jpg" alt="">
</div>
    <script>

        //点击验证码
        function changeVerify(obj) {
            obj.src="${path}vs?date="+new Date().getTime();
        }

        $(function ()
        {
            $("#sub").click(function ()
            {
//手机号不为空
                    var phone= $("[name=phone]").val();
                    if(phone==null||phone=="")
                    {
                        $("#msg").text("手机号不能为空").css("color","red");
                        $("#phone").focus();
                        return;
                    }
                    //手机号格式
                if(!/^1[3456789]\d{9}$/.test(phone))
                {
                    $("#msg").text("手机号格式错误").css("color","red");
                    $("#phone").focus();
                    return;

                }

                var code=$("[name=code]").val();
                //验证码不为空
                if(code==null||code=="")
                {
                    $("#msg").text("验证码不能为空").css("color","red");
                    $("#code").focus();
                    return;
                }
                $.ajax({
                    url:"user",
                    data:{"code":code,"method":"checkCode"},
                    type:"post",
                    dataType:"json",
                    success:function (res) {
                        if(!res)
                        {
                            $("#msg").text("验证码不正确").css("color","red");
                            $("[name=code]").focus();
                        }
                        else
                        {
                            //提交表单
                            $("form").submit();
                        }
                    }
                })

            })

        })
    </script>

</body>
</html>