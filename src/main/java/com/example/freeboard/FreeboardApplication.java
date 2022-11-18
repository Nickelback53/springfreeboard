package com.example.freeboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.example.freeboard")
public class FreeboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeboardApplication.class, args);
	}

}
