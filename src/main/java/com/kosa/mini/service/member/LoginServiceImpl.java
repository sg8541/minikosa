package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.LoginDTO;
import com.kosa.mini.domain.member.Member;
import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.exception.LoginException;
import mybatis.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginMapper loginMapper;

    @Autowired
    public LoginServiceImpl(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public UserSessionDTO authenticate(LoginDTO loginDTO) throws LoginException {
        Member member = loginMapper.findByEmail(loginDTO.getEmail());
        if (member == null) {
            throw new LoginException("존재하지 않는 이메일입니다.");
        }

        // 비밀번호 비교 (평문 비밀번호 사용)
        if (!member.getPassword().equals(loginDTO.getPassword())) {
            throw new LoginException("비밀번호가 일치하지 않습니다.");
        }

        // UserSessionDTO로 매핑
        UserSessionDTO userSession = new UserSessionDTO();
        userSession.setMemberId(member.getMemberId());
        userSession.setName(member.getName());
        userSession.setEmail(member.getEmail());
        userSession.setNickname(member.getNickname());
        userSession.setRoleId(member.getRoleId());

        return userSession;
    }
}
