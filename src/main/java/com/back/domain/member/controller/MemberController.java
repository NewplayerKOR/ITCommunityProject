package com.back.domain.member.controller;

import com.back.domain.member.dto.*;
import com.back.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping("/join")
    public ResponseEntity<MemberJoinResponse> join(@RequestBody MemberJoinRequest memberJoinRequest) {
        MemberJoinResponse memberJoinResponse = memberService.join(memberJoinRequest);
        return ResponseEntity.ok(memberJoinResponse);
    }

    /**
     * 로그인
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable Long memberId) {
        MemberResponse memberResponse = memberService.getMember(memberId);
        return ResponseEntity.ok(memberResponse);
    }

    /**
     * 닉네임 수정
     */
    @PatchMapping("/{memberId}/nickname")
    public ResponseEntity<Void> updateNickname(
            @PathVariable Long memberId,
            @RequestBody NicknameUpdateRequest nicknameUpdateRequest) {
        memberService.updateNickname(memberId, nicknameUpdateRequest);
        return ResponseEntity.ok().build();
    }

    /**
     * 비밀번호 변경
     */
    @PatchMapping("/{memberId}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long memberId,
            @RequestBody PasswordChangeRequest passwordChangeRequest) {
        memberService.changePassword(memberId, passwordChangeRequest);
        return ResponseEntity.ok().build();
    }
}
