package com.sly.seata.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * business 启动类
 * @author sly
 * @time 2019年6月12日
 */
//@EnableTransactionManagement
@EnableEurekaClient
@EnableFeignClients(basePackages="com.sly.seata")
@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan(basePackages="com.sly.seata")
public class BusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessApplication.class, args);
	}

}
