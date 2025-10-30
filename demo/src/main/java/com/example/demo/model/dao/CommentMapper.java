package com.example.demo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.dto.Comment;

@Mapper

public interface CommentMapper {
	@Insert("INSERT INTO FOOD_COMMENT VALUES(#{foodNo},#{content},SYSDATE)")
	int saveComment(Comment comment);
	@Select("""
				SELECT 
				       SEQ foodNo
				     , CONTENT
				     , CREATE_DATE createDate
				  FROM
				        FOOD_COMMENT
				 WHERE
				        SEQ= #{seq}
				  ORDER
				      BY 
				         createDate DESC
				         
			""")
List<Comment> selectComment(Long seq);
	
List<Comment> selectAll(Long seq);
}

