package com.back.domain.member.entity;

import com.back.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /** 생성자 (Builder 패턴 사용) */
    @Builder
    public Member(String email, String password, String nickname, Role role) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
    }

    /** Entity 생성 정적 팩토리 메서드 */
    public static Member createMember(String email, String password, String nickname, Role role) {
        return Member.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .role(role)
                .build();
    }

    /** 비즈니스 로직: 회원 정보 수정 */
    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    /** 비즈니스 로직: 비밀번호 수정 */
    public void updatePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
