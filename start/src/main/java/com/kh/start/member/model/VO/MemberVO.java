package com.kh.start.member.model.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class MemberVO {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String role;
}
