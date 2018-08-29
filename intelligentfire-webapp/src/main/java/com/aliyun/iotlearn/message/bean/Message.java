package com.aliyun.iotlearn.message.bean;

import java.util.List;
import java.util.Map;

/**
 * @Author 安悟
 * @Date 2018/7/10 上午11:46
 */
public class Message {
	public static final String MESSAGE_TYPE_DEVICE_PROPERTY_CHANGED = "DEVICE_PROPERTY_CHANGED";
	/**
	 * 设备iotId
	 */
	private String iotId;
	private String messageType;
	private List<String> groupIdList;
	private String batchId;
	private long gmtCreate;
	private String productKey;
	private Map<String, Object> items;
}
