package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.domain.member.Member;

public interface EditProfileService {
    EditProfileDTO getMemberById(Long memberId);
    void updateMember(Member member);
    boolean isNicknameExists(String nickname);
}
