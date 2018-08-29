package com.aliyun.iotlearn.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 安悟
 * @Date 2018/6/29 下午5:47
 */
@Component
@ConfigurationProperties(prefix = "iotenv")
public class IoTEnvironment {
	private String appkey;
	private String appsecret;
	private String modelVersion;
	private String deviceVersion;
	private String eventVersion;
	private String host;

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getEventVersion() {
		return eventVersion;
	}

	public void setEventVersion(String eventVersion) {
		this.eventVersion = eventVersion;
	}

	@Override
	public String toString() {
		return "IoTEnvironment{" +
				"appkey='" + appkey + '\'' +
				", appsecret='" + appsecret + '\'' +
				", modelVersion='" + modelVersion + '\'' +
				", deviceVersion='" + deviceVersion + '\'' +
				", eventVersion='" + eventVersion + '\'' +
				", host='" + host + '\'' +
				'}';
	}
}
