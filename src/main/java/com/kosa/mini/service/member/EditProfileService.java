package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.EditProfileException;
import com.kosa.mini.exception.SignupException;

public interface EditProfileService {
    int EditProfile(EditProfileDTO editProfileDTO) throws DuplicateNicknameException, EditProfileException;

    boolean isNicknameExists(String nickname);

}
