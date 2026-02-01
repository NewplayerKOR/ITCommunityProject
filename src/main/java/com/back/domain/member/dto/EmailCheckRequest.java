package com.back.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 이메일 중복 확인 요청 DTO
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailCheckRequest {
    private String email;
}