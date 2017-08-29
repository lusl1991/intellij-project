<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/29
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getServerName() + ":"
            + request.getServerPort() + path + "/";
    String basePath2 = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<script type="text/javascript" src="../assets/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="../assets/websocket/websocket.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <input type="file" />
    <button onclick="upload()">上传文件</button>
</body>
<script>
    function upload(){
        var qyid = 1000;
        var path = '<%=basePath %>';
        console.log(path);
        var system = IWebSocket({
            uri:"ws",
            socketJsUri:"ws/sockjs",
            host:path,
            uid:qyid,
            // 可以自定义四大事件
            /*
            ,onOpen: function(event) {
            }
            ,onMessage: function(event){
            }
            ...
            */
        });
    }
</script>
</html>
