package com.aliyun.iotlearn.common.config;

import com.aliyun.iotlearn.message.listener.MyMessageListener;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.bean.ConsumerBean;
import com.aliyun.openservices.ons.api.bean.Subscription;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 消息监听配置
 * @Author 安悟
 * @Date 2018/7/6 下午1:39
 */
@Configuration
@ImportResource(locations = {"classpath:consumer.xml"})
public class MessageListenerConfig {

	/*@Bean(initMethod = "start", destroyMethod = "shutdown")
	public ConsumerBean consumer(MessageListenerEnvironment messageListenerEnvironment) {
		ConsumerBean consumerBean = new ConsumerBean();

		System.out.println(messageListenerEnvironment);
		Properties properties = new Properties();
		properties.put("ConsumerId", messageListenerEnvironment.getConsumerId());
		properties.put("AccessKey", messageListenerEnvironment.getAccessKey());
		properties.put("SecretKey", messageListenerEnvironment.getSecretKey());
		properties.put("ConsumeThreadNums", messageListenerEnvironment.getConsumeThreadNums());
		consumerBean.setProperties(properties);

		Map<Subscription, MessageListener> subscriptionTable = new HashMap<>();
		Subscription subscription = new Subscription();
		subscription.setTopic(messageListenerEnvironment.getTopic());
		subscription.setExpression("*");
		subscriptionTable.put(subscription, new MyMessageListener());
		consumerBean.setSubscriptionTable(subscriptionTable);

		return consumerBean;
	}*/

	/*@Bean
	public MessageListener myMessageListener() {
		return new MyMessageListener();
	}*/
}
