package com.heimao.wuye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 
 * @author wuyeheimao
 * @time   2017年10月27日 下午1:08:22
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.heimao.wuye.mapper")
public class WuyeApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WuyeApplication.class, args);
	}
}
