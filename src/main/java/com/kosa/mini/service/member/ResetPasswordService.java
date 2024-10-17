package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.ResetPasswordDTO;

public interface ResetPasswordService {

    boolean resetPassword(ResetPasswordDTO resetPasswordDTO) throws Exception;

    ResetPasswordDTO searchMember(String name, String phoneNumber, String email);
}
