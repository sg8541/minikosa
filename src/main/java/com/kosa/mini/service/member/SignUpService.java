package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.SignupDTO;
import org.springframework.stereotype.Service;

@Service
public interface SignUpService {

    public boolean signUp(SignupDTO dto);
}
