package com.aliyun.iotlearn.message.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author 安悟
 * @Date 2018/7/6 下午4:34
 */
@Component
@ServerEndpoint(value = "/websocket")
public class WebSocketServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);

	// 记录当前在线连接数
	private static int onlineCount = 0;
	// 存储客户端对应的WebSocket对象
	private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

	// 与客户端的连接会话,通过它来给客户端发送数据
	private Session session;

	/**
	 * 连接建立成功
	 */
	@OnOpen
	public void onOpen(Session session) {
		this.session = session;

		webSocketSet.add(this);

		addOnlineCount();
		LOGGER.info("新连接建立,当前连接数为" + getOnlineCount());
		try {
			sendMessage("connect.success");
		} catch (IOException e) {
			LOGGER.error("连接异常", e);
		}
	}

	/**
	 * 连接关闭
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);

		subOnlineCount();

		LOGGER.info("有连接关闭,当前连接数为" + getOnlineCount());
	}

	/**
	 * 收到客户端消息
	 * @param message
	 * @param session
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		LOGGER.info("receive message:" + message);

		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 发生错误
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		LOGGER.error("error occur", error.getClass());
	}

	/**
	 * 发送消息到客户端
	 * @param message
	 * @throws IOException
	 */
	private void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	/**
	 * 发送消息
	 * @param message
	 */
	public static void send(String message) {
		LOGGER.info(message);
		for (WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (IOException e) {
				LOGGER.error("", e);
				continue;
			}
		}
	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}

	public static void main(String[] args) {
		WebSocketServer.send("hello, world");
	}
}
