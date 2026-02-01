package com.back.domain.member.dto;

import lombok.*;

/**
 * 닉네임 변경을 위한 요청 dto
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NicknameUpdateRequest {
    private String nickname;
}
