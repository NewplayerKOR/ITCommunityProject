package com.back.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 닉네임 중복 확인 요청 dto
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NicknameCheckRequest {
    private String nickname;
}