package com.back.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원가입 완료 후 반환되는 최소 정보 dto
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberJoinResponse {
    private Long id;
    private String email;
    private String nickname;
}
