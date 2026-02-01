package com.back.domain.member.dto;

import lombok.*;

/**
 * 신규 회원가입을 위한 사용자 입력 정보 dto
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinRequest {
    private String email;
    private String password;
    private String nickname;
}
