package com.kh.start.member.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.start.member.model.VO.MemberVO;
import com.kh.start.member.model.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	@Insert("INSERT INTO BOOT_MEMBER VALUES(#{memberId},#{memberPwd},#{memberName},#{role})")
	int signUp(MemberVO member);
	
	@Select("SELECT COUNT(*) FROM BOOT_MEMBER WHERE MEMBER_ID = #{memberId}")
	int countByMemberId(String memberId);
	
	@Select ("""
				SELECT
				        MEMBER_ID memberId
				      , MEMBER_PWD memberPwd
				      , MEMBER_NAME memberName
				      , role
				  FROM 
				        BOOT_MEMBER
				 WHERE
				        MEMBER_ID =#{memberId}
				        
			""")
	MemberDTO loadUser(String memberId);
}

