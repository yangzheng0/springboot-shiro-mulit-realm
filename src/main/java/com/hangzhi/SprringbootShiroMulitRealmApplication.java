package com.hangzhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hangzhi.dao")
public class SprringbootShiroMulitRealmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprringbootShiroMulitRealmApplication.class, args);
	}
}
