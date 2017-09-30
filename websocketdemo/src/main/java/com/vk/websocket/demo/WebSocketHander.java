package com.vk.websocket.demo;

import org.apache.log4j.Logger;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

public class WebSocketHander implements WebSocketHandler {
	
	private static final Logger logger = Logger.getLogger(WebSocketHander.class);

	private static final ArrayList<WebSocketSession> users = new ArrayList<>();

	// 初次链接成功执行
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.debug("链接成功......");
		users.add(session);
		String userName = (String) session.getAttributes().get("username");
		if (userName != null) {
			// 查询未读消息
			int count = 5;
			session.sendMessage(new TextMessage(count + ""));
		}
	}

	// 接受消息处理消息
	@Override
	public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage)
			throws Exception {
		sendMessageToUsers(new TextMessage(webSocketMessage.getPayload() + ""));
	}

	@Override
	public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
		if (webSocketSession.isOpen()) {
			webSocketSession.close();
		}
		logger.debug("链接出错，关闭链接......");
		users.remove(webSocketSession);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
		logger.debug("链接关闭......" + closeStatus.toString());
		users.remove(webSocketSession);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

	/**
	 * 给所有在线用户发送消息
	 *
	 * @param message
	 */
	public void sendMessageToUsers(TextMessage message) {
		logger.info(message);
		for (WebSocketSession user : users) {
			try {
				if (user.isOpen()) {
					user.sendMessage(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
