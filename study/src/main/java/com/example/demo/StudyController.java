package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //이 클래스는 컨트롤러고 ,반환값을 자공으로JSON으로 변환해서 응답해줘 라는 뜻임
@RequestMapping("study") //url요청이 오면 이메서드/클래스로 처리해줘 여기서 study가 url이다.
//결론은 /study url로 오는 요청을 여기 StudyController로 처리해줘라고 spring에게 알려주는거다 그래서 애노테이션을 통해 등록하는거고
//SpringWebStater는 기본적으로JSON형태로 Converting해줄 수 있는 Jackson라이브러리 포함
//produces기본값이 application/json; charset=UTF-8이기 때문에
//자동으로 MessageConverter로 변환됨 잘 응답됨
public class StudyController {

	/*
	 * Spring Boot썼을 때 장점
	 * 
	 */
	
	
	/*
	 * SpringStarter
	 * 
	 * 특정 기능에 필요한 의존성 라이브러리들을 한 번에 관리 할 수있는 개념
	 * 
	 * 각각의 Stater는 관련된 라이브러리들의 집합으로 모든 의존성을 하나의 Stater로 관리하고
	 * 예)
	 * spring-boot-start-web : 웹 애플리케이션 개발에 필요한 의존성들이 모여있음
	 * (Servlet,DispatcherSErvlet, MVC,Jackson등)
	 * spring-boot-starter-security : 스프링 시큐리티(보안) 관련된 의존성들이 모여있음
	 * 
	 * 개발자는 필요한 기능이 있다-> stater추가해야지 -> 의존성 관리를 직접하지 않음
	 * 모든 개발자가 동일한 Stater를 쓰기 때문에 프로젝트 간 의존성 충돌도 방지할 수 있음
	 * Starter에 모든 라이브러리가 존재하는 것은 아님
	 * 
	 * 
	 */
	@Autowired //spring이 필요한 객체를 가져다 주는거임 
	//즉 StudyBean을 찾아서 studyBean이라는 변수에 spring이 알아서 찾아서 넣어주는 애노테이션 
	private StudyBean studyBean;
	@GetMapping
	public ResponseEntity<String> getTest(){
		return ResponseEntity.ok("응답잘갑니다");
	}
	
	
	
}
