package com.aliyun.iotlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动入口
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.aliyun.iotlearn")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
