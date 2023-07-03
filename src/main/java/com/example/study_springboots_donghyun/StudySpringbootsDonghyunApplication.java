package com.example.study_springboots_donghyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 실행이 안 되는 이유는?
// @ComponentScan("com.example.dao")

@SpringBootApplication
public class StudySpringbootsDonghyunApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringbootsDonghyunApplication.class, args);
	}

}
