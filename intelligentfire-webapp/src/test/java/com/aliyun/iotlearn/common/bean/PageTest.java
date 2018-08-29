package com.aliyun.iotlearn.common.bean;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author 安悟
 * @Date 2018/7/9 下午5:57
 */
public class PageTest {
	@Test
	public void setTotalRecords() throws Exception {
		Page<Integer> page = new Page<>(1, 10);
		page.setTotalRecords(29);

		for (int i = page.getPageStartIndex(); i <= page.getPageEndIndex(); i++) {
			System.out.print(i + ", ");
		}
	}

}