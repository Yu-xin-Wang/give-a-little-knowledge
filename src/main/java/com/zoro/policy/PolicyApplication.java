package com.zoro.policy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@ComponentScan
@MapperScan(value = "com.zoro.policy.dao")
@EnableRedisHttpSession
public class PolicyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(PolicyApplication.class, args);
	}

}

