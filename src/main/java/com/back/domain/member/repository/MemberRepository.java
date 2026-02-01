package com.back.domain.member.repository;

import com.back.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    /**
     * 이메일로 회원 정보 조회
     * 로그인, 회원 정부 수정 등 '객체 데이터' 필요시
     */
    Optional<Member> findByEmail(String email);

    /**
     * 이메일 존재 여부 확인(단순 가입 여부 확인, 성능 이점)
     */
    boolean existsByEmail(String email);

    /**
     * 닉네임 중복 확인
     */
    boolean existsByNickname(String nickname);
}
