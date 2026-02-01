package com.back.domain.member.dto;

import com.back.domain.member.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 성공시 반환되는 사용자 정보 dto
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String nickname;
    private Role role;
    // 추후 JWT 도입시 String accessToken 필드 추가
}
