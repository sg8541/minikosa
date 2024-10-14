package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateResourceException;
import com.kosa.mini.exception.InvalidDataException;
import mybatis.dao.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final SignUpMapper signUpMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(SignUpMapper signUpMapper) {
        this.signUpMapper = signUpMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public void signUp(SignupDTO dto) throws DuplicateResourceException, InvalidDataException {
        if (!isNicknameAvailable(dto.getNickname())) {
            throw new DuplicateResourceException("닉네임이 이미 존재합니다.");
        }
        if (!isEmailAvailable(dto.getEmail())) {
            throw new DuplicateResourceException("이메일이 이미 존재합니다.");
        }
        if (dto.getPassword().length() < 4) {
            throw new InvalidDataException("비밀번호는 최소 4자 이상이어야 합니다.");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        int result = signUpMapper.insert(dto);
        if (result <= 0) {
            throw new InvalidDataException("회원가입에 실패했습니다.");
        }
    }

    @Override
    public boolean isNicknameAvailable(String nickname) {
        return signUpMapper.countByNickname(nickname) == 0;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        return signUpMapper.countByEmail(email) == 0;
    }
}
