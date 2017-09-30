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
<script type="text/javascript" src="<%=path%>/assets/js/common/jquery/jquery1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/assets/websocket/websocket.js"></script>
<script type="text/javascript" src="<%=path%>/assets/js/echart/build/dist/echarts.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body onload="initwebsocket()">
    <input type="file" />
    <button onclick="upload()">上传文件</button>
    <div id="aa" style="width:100%;height:380px;border:1px solid red;margin-top:50px;"></div>
</body>
<script>
    var myChart;

    require.config({
        paths:{
            echarts:'<%=path%>/assets/js/echart/build/dist'
        }
    });

    require(
        [
            'echarts',
            'echarts/chart/pie'
        ],DrawEchart
    )

    function DrawEchart(ec){
        myChart = ec.init(document.getElementById("aa"));
    }

    //成功数颜色
    var labelTop = {
        normal : {
            color : '#5cb85c',
            label : {
                show : true,
                position : 'center',
                formatter : '{b}',
                textStyle: {
                    baseline : 'bottom'
                }
            },
            labelLine : {
                show : false
            }
        }
    };

    //失败数颜色
    var labelBottom = {
        normal : {
            color: '#d9534f',
            label : {
                show : true,
                position : 'center'
            },
            labelLine : {
                show : false
            }
        },
        emphasis: {
            color: 'rgba(0,0,0,0)'
        }
    };

    function upload(){
        $.ajax({
            type:"POST",
            url:"/websocket/test",
            dataType:"json",
            data:{"qyid":1000},
            success : function (data) {

            }
        });
    }

    function initwebsocket(){
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

    function echart(cc){
        //饼图中间label
        var labelFromatter = {
            normal : {
                label : {
                    formatter : function(params) {
                        return (100 - params.percent).toFixed(2) + '%';
                    },
                    textStyle : {
                        baseline : 'top',
                        fontSize : '18',
                        fontWeight : 'lighter'
                    },
                    show : true
                },
                labelLine : {
                    show : true
                }
            },
        };

        var option = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            series: [
                {
                    name:'文件上传',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:cc,
                    itemStyle : labelFromatter
                }
            ]
        };
        myChart.setOption(option);
    }
</script>
</html>
