示例说明
==
本工程是一个标准的spring boot工程,页面使用thymeleaf模板技术,配置信息在src/main/resources/application.yml文件中
消息推送相关配置在src/main/resources/consumer.xml中

运行说明
==
* 本工程可以直接导入到IDE中,也可以使用maven打成jar包直接运行
* 运行前需要修改src/main/resources/application.yml文件,将其中涉及到iot SDK 配置相关的部分改成自己的配置
* 示例默认打开了消息推送功能,需要提前开通消息队列服务,文档如下[消息队列服务](https://www.aliyun.com/product/ons?spm=5176.8142029.cloudEssentials.58.e9396d3e6nqdke)
开通后需要将相应的配置更新到src/main/resources/consumer.xml中
* 如果不想使用推送功能,在运行示例前需要将类com.aliyun.iotlearn.common.config.MessageListenerConfig中的@Configuration这一行注释掉
* 示例导入到IDE中后可以打开com.aliyun.iotlearn.App类,这是一个启动类,里面有个标准的main方法,可以启动运行,或者命令行使用maven运行,命令如下:mvn clean spring-boot:run;如果需要打包,使用
如下maven命令: mvn clean package spring-boot:repackage
