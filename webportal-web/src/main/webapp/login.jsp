<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/30
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Login</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
    <link rel="icon" href="<%=path%>/assets/ico/favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="<%=path%>/assets/ico/favicon.ico" type="image/x-icon" />
    <!-- CSS -->
    <link rel="stylesheet" href="<%=path%>/assets/css/login/reset.css"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/login/supersized.css"/>
    <link rel="stylesheet" href="<%=path%>/assets/css/login/style.css"/>

</head>
<body>
    <div id="particles-js"></div>
    <div class="page-container">
        <h1>Login</h1>
        <form id="_form" action="" method="post">
            <input type="text" name="account" class="username" placeholder="请输入管理员账号" value="admin">
            <input type="password" name="password" class="password" placeholder="请输入登录密码" value="123456">
            <input type="text" name="captcha" class="captcha" placeholder="请输入验证码" >
            <img src="captcha/getCaptchaCode" id="img_captcha" onclick="refresh()">
            <button type="button" id="login">Login</button>
        </form>
    </div>

    <!-- Javascript -->
    <script src="<%=path%>/assets/js/common/jquery/jquery1.8.3.min.js"></script>
    <script src="<%=path%>/assets/js/common/MD5.js"></script>
    <script src="<%=path%>/assets/js/common/supersized.3.2.7.min.js"></script>
    <script src="<%=path%>/assets/js/common/supersized-init.js"></script>
    <script src="<%=path%>/assets/js/common/layer/layer.js"></script>
    <script src="<%=path%>/assets/js/canvas/particles.js"></script>
    <script src="<%=path%>/assets/js/canvas/app.js"></script>
    <script src="<%=path%>/assets/js/ajax/ajax.js"></script>

    <script>
        function refresh(){
            document.getElementById('img_captcha').src = encodeURI('captcha/getCaptchaCode?' + new Date());
        }

        $("#login").click(function(){
            var obj = {};
            var account = $("input[name=account]").val();
            var password = $("input[name=password]").val();
            var captcha = $("input[name=captcha]").val();
            obj.account = account;
            obj.password = password;
            obj.captcha = captcha;
            ajax.postAsync("api/login",false,obj,function(response){
                refresh();
                if(response.success){
                    window.location = "jsp/home.jsp";
                }else{
                    alert(response.message);
                }
            })
        })
    </script>
</body>
</html>
