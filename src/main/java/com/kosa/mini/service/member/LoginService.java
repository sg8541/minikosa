package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.LoginDTO;
import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.exception.LoginException;

public interface LoginService {
    UserSessionDTO authenticate(LoginDTO loginDTO) throws LoginException;
}
