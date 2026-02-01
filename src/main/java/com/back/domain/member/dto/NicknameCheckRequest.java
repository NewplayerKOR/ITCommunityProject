package com.back.domain.member.dto;

import lombok.*;

/**
 * 닉네임 중복 확인 요청 dto
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NicknameCheckRequest {
    private String nickname;
}