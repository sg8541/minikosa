package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateEmailException;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.SignupException;

public interface SignUpService {
    boolean signUp(SignupDTO dto) throws DuplicateEmailException, DuplicateNicknameException, SignupException;

    // 중복 검사 메서드 추가
    boolean isEmailExists(String email);
    boolean isNicknameExists(String nickname);
}
