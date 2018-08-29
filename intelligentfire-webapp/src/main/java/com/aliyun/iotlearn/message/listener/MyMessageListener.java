package com.aliyun.iotlearn.message.listener;

import com.aliyun.iotlearn.common.util.JsonUtil;
import com.aliyun.iotlearn.message.websocket.WebSocketServer;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @Author 安悟
 * @Date 2018/7/6 上午11:54
 */
public class MyMessageListener implements MessageListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyMessageListener.class);

	@Override
	public Action consume(Message message, ConsumeContext consumeContext) {
		try {
			String payload = new String(message.getBody(), "utf-8");
			LOGGER.debug("===Receive message, topic = {}, messageId = {}, content = {}",
					message.getTopic(), message.getMsgID(), payload);

			/*Map<String, Object> objectMap = JsonUtil.jsonString2Map(payload);
			String messageType = objectMap.get("messageType").toString();
			String iotId = objectMap.get("iotId").toString();
			String productKey = objectMap.get("productKey").toString();*/

			// 消息结构中没有device name信息,但是有iotId,可以通过知道是哪个设备的消息
			WebSocketServer.send(payload);

			return Action.CommitMessage;
		} catch (Exception e) {
			LOGGER.error("", e);
			//消费失败
			return Action.ReconsumeLater;
		}
	}
}
