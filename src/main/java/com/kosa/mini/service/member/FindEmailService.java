package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.FindEmailDTO;

public interface FindEmailService {
    String findEmail(FindEmailDTO findEmailDTO) throws Exception;
}
