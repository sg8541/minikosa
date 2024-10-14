package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
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
    public boolean signUp(SignupDTO dto) {
        return signUpMapper.insert(dto);
    }
}
