package com.zoro.policy;

import com.alibaba.fastjson.JSON;
import com.zoro.policy.dto.ServiceResult;
import com.zoro.policy.entity.BusinessPlatform;
import com.zoro.policy.service.PlatformService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PolicyApplicationTests {

	@Resource
	private PlatformService platformService;


	@Autowired
	private JavaMailSender jms;
	/***
	 * 添加交易平台
	 */
	@Test
	public void addPlatform() {
		BusinessPlatform platform=new BusinessPlatform();
		platform.setPlatformCode("1000");
		platform.setPlatformName("金蝉电子商务有限公司");
		platform.setCreateUser("范俊杰");
		platform.setCreateTime(new Date());
		platform.setUpdateUser("范俊杰");
		platform.setUpdateTime(new Date());
		ServiceResult<BusinessPlatform> serviceResult=this.platformService.addPlatform(platform);
		System.out.println(JSON.toJSONString(serviceResult));
	}

	/***
	 * 邮件发送
	 */
	@Test
	public void sendMail(){
		//建立邮件消息
		SimpleMailMessage mainMessage = new SimpleMailMessage();
		//发送者
		mainMessage.setFrom("907121461@qq.com");
		//接收者
		mainMessage.setTo("907121461@qq.com");
		//发送的标题
		mainMessage.setSubject("哈喽");
		//发送的内容
		mainMessage.setText("hello world");
		jms.send(mainMessage);
	}

}

