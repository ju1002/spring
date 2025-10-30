package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		
		/*
		 * 1.AutoConfiguration(자동 구성)
		 * 스프링 부트의 핵심 기능!
		 * 애플리케이션의 클래스 패스에 존재하는 라이브러리 및 설정을 기반을 Bean을 자동으로 구성해줌
		 * 원래는 bean태그를 이용하여 등록을 직접 했어야 했는데 이제 자동으로 만들어줌
		 * 
		 * 개발자가 복잡한 설정을 건너뛰고 바로 개발을 시작할 수 있음
		 * 
		 * @EnableAutoConfiguration
		 * 스프링부트의 자동구성을 활성화 해주는 애노테이션
		 * 안에 Componentscan이 있어서 알아서 Spring에게 bean을 찾을 범위를 지정해준다.
		 * 
		 * 동작시작
		 * @SpringBootApplication 애노테이션이 붙은 클래스의
		 * 	main메서드가 호출 됨
		 * 
		 * 자동구성활성화 => @EnableAutoConfiguration을 통해 자동구성을 활성화
		 * 
		 * 모든 자동구성이 활성화가 끝나면 애플리케이션 실행
		 * 
		 * 
		 * =>@Configuration 이게 뭘까?
		 * 
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		SpringApplication.run(StudyApplication.class, args);
	}

}
