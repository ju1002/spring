package com.kh.start.token.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.start.token.model.dao.TokenMapper;
import com.kh.start.token.model.vo.RefreshToken;
import com.kh.start.token.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {
	private final JwtUtil tokenUtil;
	private final TokenMapper tokenMapper;

	public Map<String,String> generateToken(String username) {
//		String accessToken =tokenUtil.getAccessToken(username);
//		String refreshToken = tokenUtil.getRefreshToken(username);
//		log.info("엑세스토큰{},리프레시 토큰{}",accessToken,refreshToken);

	Map<String, String> tokens = createTokens(username);
	
	saveToken(tokens.get("refreshToken"), username);
	
	return tokens;
	}

	private Map<String, String> createTokens(String username) {
		String accessToken = tokenUtil.getAccessToken(username);
		String refreshToken = tokenUtil.getRefreshToken(username);
		log.info("엑세스토큰{},리프레시 토큰{}", accessToken, refreshToken);

		Map<String, String> tokens = new HashMap();

		tokens.put("accessToken", accessToken);
		tokens.put("refreshToken", refreshToken);
		return tokens;
	}

	private void saveToken(String refreshToken, String username) {

		RefreshToken token = RefreshToken.builder().token(refreshToken).username(username)
				.expiration(System.currentTimeMillis() + 36000000L * 72).build();
		

		tokenMapper.saveToken(token);
	}

	// 인증에 성공 했을 때
	// JwtUtil에 정의 해놓은
	// getAccessToken메서드 호출
	// getRefreshToken메서드 호출
	// RefreshToken의 경우 DB의 Token테이블에 만들어진 Token을 INSERT
	// 두개를 어디다 고이 예쁘게 담아서 AuthServiceImpl의 login메서드로 반환

	// 추후 AccessToken의 만료기간이 지나서 토큰 갱신 요청이 들어왔을 때
	// 사용자에게 전달받은 RefreshToken이 DB에 존재하면서 만료기간이 지나지 않았는지를 검증하는 메소드

}
