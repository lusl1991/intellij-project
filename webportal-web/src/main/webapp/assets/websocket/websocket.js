var IWebSocket = function(json) {
    var options = {
        uri:"ws",
        sockJsUri:"ws/sockjs",
        host:"localhost:18080/", // 项目路径:[IP]:[Port]/[ProjectName]
        uid:"0",
        onOpen:function(event) {
            // 自定义WSC连接事件：服务端与前端连接成功后触发
            console.log("websocket连接成功");
        },
        onMessage:function(event) {
            // 自定义WSC消息接收事件：服务端向前端发送消息时触发

            var data=JSON.parse(event.data);
            var total = data.total;
            var success = data.success;
            var fail = total - success;
            var cc = [];
            cc.push({"name":"成功率","value":success,itemStyle:labelTop});
            cc.push({"name":"失败率","value":fail,itemStyle:labelBottom});
            if(total>0){
                echart(cc);
            }
        },
        onError:function(event) {
            // 自定义WSC异常事件：WSC报错后触发
            console.log("websocket异常");
        },
        onClose:function(event) {
            // 自定义WSC关闭事件：WSC关闭后触发
            console.log("websocket关闭");
        }
    };
    $.extend(options, json);

    var websocket;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://" + options.host + options.uri + "?qyid=" + options.uid);
    } else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://" + options.host + options.uri + options.uid);
    } else {
        websocket = new SockJS("http://" + options.host + options.sockJsUri + options.uid);
    }

    websocket.onopen = function(evnt) {

        options.onOpen(evnt);
    };
    websocket.onmessage = function(evnt) {

        options.onMessage(evnt);
    };
    websocket.onerror = function(evnt) {

        options.onError(evnt);
    };
    websocket.onclose = function(evnt) {

        options.onClose(evnt);
    };

    return websocket;
}