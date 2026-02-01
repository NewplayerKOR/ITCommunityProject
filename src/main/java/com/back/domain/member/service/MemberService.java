package com.back.domain.member.service;

import com.back.domain.member.dto.*;
import com.back.domain.member.entity.Member;
import com.back.domain.member.entity.Role;
import com.back.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // 기본 읽기 전용 설정으로 성능 최적화
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    public MemberJoinResponse join(MemberJoinRequest memberJoinRequest) {
        // 이메일 중복 검증
        if (memberRepository.existsByEmail(memberJoinRequest.getEmail())) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        // 엔티티 생성 및 저장
        Member member = Member.builder()
                .email(memberJoinRequest.getEmail())
                .password(passwordEncoder.encode(memberJoinRequest.getPassword())) // 암호화 필수
                .nickname(memberJoinRequest.getNickname())
                .role(Role.USER)
                .build();

        Member savedMember = memberRepository.save(member);

        return MemberJoinResponse.from(savedMember);

    }

    /**
     * 로그인
     */
    public LoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        if (!passwordEncoder.matches(loginRequest.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return LoginResponse.from(member);
    }

    /**
     * 회원 상세 정보 조회
     */
    public MemberResponse getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        return MemberResponse.from(member);
    }

    /**
     * 닉네임 수정
     */
    @Transactional
    public void updateNickname(Long memberId, NicknameUpdateRequest nicknameUpdateRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        if (memberRepository.existsByNickname(nicknameUpdateRequest.getNewNickname())) {
            throw new RuntimeException("이미 존재하는 닉네임입니다.");
        }

        member.updateNickname(nicknameUpdateRequest.getNewNickname());
    }

    /**
     * 비밀번호 변경
     */
    @Transactional
    public void changePassword(Long memberId, PasswordChangeRequest passwordChangeRequest) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        if (!passwordEncoder.matches(passwordChangeRequest.getNewPassword(), member.getPassword())) {
            throw new RuntimeException("현재 비밀번호가 일치하지 않습니다.");
        }

        member.updatePassword(passwordEncoder.encode(passwordChangeRequest.getNewPassword()));
    }
}