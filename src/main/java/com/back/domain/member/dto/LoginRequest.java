package com.back.domain.member.dto;

import lombok.*;

/**
 * 로그인을 위한 인증 정보(이메일, 비밀번호) 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginRequest {
    private String email;
    private String password;
}
