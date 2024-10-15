package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateEmailException;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.SignupException;
import mybatis.dao.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final SignUpMapper signUpMapper;

    @Autowired
    public SignUpServiceImpl(SignUpMapper signUpMapper) {
        this.signUpMapper = signUpMapper;
    }

    @Override
    public boolean signUp(SignupDTO dto) throws DuplicateEmailException, DuplicateNicknameException, SignupException {
        try {
            if(signUpMapper.existsByEmail(dto.getEmail()) > 0) {
                throw new DuplicateEmailException("이미 사용 중인 이메일입니다.");
            }

            if(signUpMapper.existsByNickname(dto.getNickname()) > 0) {
                throw new DuplicateNicknameException("이미 사용 중인 닉네임입니다.");
            }

            return signUpMapper.insert(dto);
        } catch(DuplicateEmailException | DuplicateNicknameException e) {
            throw e;
        } catch(Exception e) {
            throw new SignupException("회원가입 중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public boolean isEmailExists(String email) {
        return signUpMapper.existsByEmail(email) > 0;
    }

    @Override
    public boolean isNicknameExists(String nickname) {
        return signUpMapper.existsByNickname(nickname) > 0;
    }
}
