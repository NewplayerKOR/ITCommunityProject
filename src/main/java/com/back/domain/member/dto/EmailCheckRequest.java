package com.back.domain.member.dto;

import lombok.*;

/**
 * 이메일 중복 확인 요청 DTO
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class EmailCheckRequest {
    private String email;
}