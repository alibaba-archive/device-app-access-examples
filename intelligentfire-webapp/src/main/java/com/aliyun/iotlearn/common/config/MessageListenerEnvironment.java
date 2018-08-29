package com.aliyun.iotlearn.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 安悟
 * @Date 2018/7/6 下午2:04
 */
@Component
@ConfigurationProperties(prefix = "msgenv")
public class MessageListenerEnvironment {
	private String consumerId;
    private String accessKey;
	private String secretKey;
    // 消费者线程数
	private int consumeThreadNums = 1;

	private String topic;

	private String ONSAddr;

	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public int getConsumeThreadNums() {
		return consumeThreadNums;
	}

	public void setConsumeThreadNums(int consumeThreadNums) {
		this.consumeThreadNums = consumeThreadNums;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getONSAddr() {
		return ONSAddr;
	}

	public void setONSAddr(String ONSAddr) {
		this.ONSAddr = ONSAddr;
	}

	@Override
	public String toString() {
		return "MessageListenerEnvironment{" +
				"consumerId='" + consumerId + '\'' +
				", accessKey='" + accessKey + '\'' +
				", secretKey='" + secretKey + '\'' +
				", consumeThreadNums=" + consumeThreadNums +
				", topic='" + topic + '\'' +
				", ONSAddr='" + ONSAddr + '\'' +
				'}';
	}
}
