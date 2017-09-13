package com.softel.controller;

import com.softel.model.utils.ResultVo;
import com.softel.websocket.MyWebSocketHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/websocket/")
public class WebSocketController {

    @Resource
    private MyWebSocketHandler handler;

    @RequestMapping("test")
    @ResponseBody
    public ResultVo websockettest(Long qyid){
        System.out.println("用户Id:" + qyid);
        try {
            handler.sendMessageToUser(qyid,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}