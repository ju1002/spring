package com.example.demo.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.Comment;
import com.example.demo.model.service.ApiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RequestMapping("api")
@RequiredArgsConstructor
@RestController
public class ApiController {
	private final ApiService apiService;
	
	@GetMapping("busan")
	public String getBusan(@RequestParam(name="pageNo") int pageNo) {
		return apiService.requestBusan(pageNo);
	}

	@GetMapping("busan/detail/{num}")
	public String getBusanDetail(@PathVariable(name="num") int num) {
		return apiService.requestBusanDetail(num);
	}
	@PostMapping("comments")
	public ResponseEntity<Integer> saveComment(@RequestBody Comment comment) {
		log.info("코멘트 넘어옴:{}",comment);
		 apiService.saveComment(comment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		//201뜨게 하는 코드 인서트가 잘 됐다.
	}
	@GetMapping("comments/{id}")
	public ResponseEntity<List<Comment>> selectAll(@PathVariable(value="id") Long seq){
		List<Comment> comments = apiService.selectAll(seq);
		return ResponseEntity.ok(comments);
		//돌려줄 데이터가 없으면 ok.build를 쓴다 삭제나 업데이트 단지 성공했다만 띄우면 되기떄문에
		//그 외에 돌려줄 응답 데이터가 있으면 ok() comments데이터를 담아서 JSON형태로보내줌
	}
}
