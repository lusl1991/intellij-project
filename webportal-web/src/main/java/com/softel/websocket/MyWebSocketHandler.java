package com.softel.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * Socket处理器
 * 
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {
	public static final Map<Long, WebSocketSession> userSocketSessionMap;
	static {
		userSocketSessionMap = new HashMap<Long, WebSocketSession>();
	}
	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Long qyid = (Long) session.getAttributes().get("qyid");
		if (userSocketSessionMap.get(qyid) == null) {
			userSocketSessionMap.put(qyid, session);
		}
	}
	/**
	 * 消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
	 */
	public void handleMessage(WebSocketSession session,WebSocketMessage<?> message) throws Exception {
		System.out.println(message.getPayload());
	}
	
	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession session,Throwable exception) throws Exception {
		if (session.isOpen()) {
			session.close();
		}
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID=" + entry.getKey());
				break;
			}
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession session,CloseStatus closeStatus) throws Exception {
		System.out.println("Websocket:" + session.getId() + "已经关闭");
		Iterator<Entry<Long, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		// 移除Socket会话
		while (it.hasNext()) {
			Entry<Long, WebSocketSession> entry = it.next();
			if (entry.getValue().getId().equals(session.getId())) {
				userSocketSessionMap.remove(entry.getKey());
				System.out.println("Socket会话已经移除:用户ID" + entry.getKey());
				break;
			}
		}
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给某个用户发送消息
	 * 
	 * @param qyid
	 * @param msg
	 * @throws IOException
	 */
	public void sendMessageToUser(Long qyid, Message msg)throws IOException {
		WebSocketSession session = userSocketSessionMap.get(qyid);
		Thread thread = new Thread();
		msg = msg==null?new Message():msg;
		for(long i=0;i<500;i++){
			if (session != null && session.isOpen()) {
				msg.setSuccess(i+1);
				msg.setTotal(500l);
				TextMessage message = new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg));
				if(i==450){
					break;
				}else{
					session.sendMessage(message);
				}
				try {
					thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 二进制文件
	 * @param session
	 * @param message
	 * @throws IOException
	 */
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException{
		String msg = message.getPayload().toString();
	}
}