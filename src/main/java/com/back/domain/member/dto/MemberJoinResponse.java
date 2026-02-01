package com.back.domain.member.dto;

import com.back.domain.member.entity.Member;
import lombok.*;

/**
 * 회원가입 완료 후 반환되는 최소 정보 dto
 */
@Getter
@Builder
@NoArgsConstructor(access  = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberJoinResponse {
    private Long id;
    private String email;
    private String nickname;

    // 팩토리 메서드(Entity -> DTO)
    public static MemberJoinResponse from(Member member) {
        return MemberJoinResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .build();
    }
}
