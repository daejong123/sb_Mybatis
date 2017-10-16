package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.daejong.mapper")
@SpringBootApplication
public class SbMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMyBatisApplication.class, args);
	}
}
