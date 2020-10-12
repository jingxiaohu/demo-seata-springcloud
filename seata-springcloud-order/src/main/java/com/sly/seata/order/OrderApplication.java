package com.sly.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * order 启动类
 * 
 * @author sly
 * @time 2019年6月12日
 */
@EnableTransactionManagement
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sly.seata.order.mapper")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
