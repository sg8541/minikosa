package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateResourceException;
import com.kosa.mini.exception.InvalidDataException;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {
    void signUp(SignupDTO dto) throws DuplicateResourceException, InvalidDataException;
    boolean isNicknameAvailable(String nickname);
    boolean isEmailAvailable(String email);
}
