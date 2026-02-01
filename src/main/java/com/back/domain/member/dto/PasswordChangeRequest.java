package com.back.domain.member.dto;

import lombok.*;

/**
 * 비밀번호 변경을 위한 요청 dto(현재/새 비밀번호 포함)
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PasswordChangeRequest {
    private String currentPassword;
    private String newPassword;
}
