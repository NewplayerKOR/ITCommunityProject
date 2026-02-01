package com.back.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 닉네임 변경을 위한 요청 dto
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NicknameUpdateRequest {
    private String nickname;
}
