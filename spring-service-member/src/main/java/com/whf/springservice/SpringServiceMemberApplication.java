package com.whf.springservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.whf.springservice.dao.mapper")
public class SpringServiceMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringServiceMemberApplication.class, args);
	}
}
