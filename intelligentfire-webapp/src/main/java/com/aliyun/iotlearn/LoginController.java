package com.aliyun.iotlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 * @Author 安悟
 * @Date 2018/6/29 下午3:32
 */
@Controller
@RequestMapping("/")
public class LoginController {

	/**
	 * 登录页面
	 * @return
	 */
	@GetMapping("login")
	public String index() {
		return "login";
	}
}
