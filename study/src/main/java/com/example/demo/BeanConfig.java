package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
	//외부에서 가져오는 클래스를 빈에 등록하는 방법 
	//1. @Configuration 을 붙여주고
	//2. 메소드 선언 내가 가져오고 싶은 클래스를 반환
	//3. 반환된 클래스는 @Bean으로 등록
	@Bean
	public StudyBean study() {
		return new StudyBean();
	}
}
//@Configuration
/*스프링에서 설정클래스를 정의할 때 사용
 * 하나 이상의 @Bean이 달린 메소드를 포함해 스프링 컨테이너에 빈으로 등록함
 * 
 * @Bean
 * @Configuration클래스 내에서 메소드에 달려서 스프링  빈을 생성함
 * 
 * 메서드의 반환값이 스프링 컨테이너에 빈으로 등록됨
 * XML으로 설정하는것보다 빠른 시점에 오류를 발견할 수 있고,
 * 코드 기반이기 때문에 자동완성/수정이 용이하고
 * 설정 클래스내에서 빈의 생성과정을 명확하게 정의할 수 있음
 * */
