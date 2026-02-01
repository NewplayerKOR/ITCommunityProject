package com.back.domain.member.dto;

import com.back.domain.member.entity.Member;
import com.back.domain.member.entity.Role;
import lombok.*;

/**
 * 로그인 성공시 반환되는 사용자 정보 dto
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponse {
    private String email;
    private String nickname;
    private Role role;

    public static LoginResponse from(Member member) {
        return LoginResponse.builder()
                .email(member.getEmail())
                .nickname(member.getNickname())
                .role(member.getRole())
                .build();
    }

    // 추후 JWT 도입시 String accessToken 필드 추가
}
