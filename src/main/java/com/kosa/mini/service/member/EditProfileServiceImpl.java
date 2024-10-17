package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.EditProfileException;
import mybatis.dao.EditProfileMapper;
import org.springframework.stereotype.Service;

@Service
public class EditProfileServiceImpl implements EditProfileService {

    private final EditProfileMapper editProfileMapper;

    public EditProfileServiceImpl(EditProfileMapper editProfileMapper) {
        this.editProfileMapper = editProfileMapper;
    }


    @Override
    public int EditProfile(EditProfileDTO dto) throws DuplicateNicknameException, EditProfileException {
        try {
            if (editProfileMapper.existsByNickname(dto.getNickname()) > 0) {
                throw new DuplicateNicknameException("이미 사용 중인 닉네임입니다.");
            }
            return editProfileMapper.updateUserProfile(dto);

        } catch (DuplicateNicknameException e) {
            throw e;
        } catch (Exception e) {
            throw new EditProfileException("회원가입 중 오류가 발생했습니다.", e);

        }

    }

    @Override
    public boolean isNicknameExists(String nickname) {
        return editProfileMapper.existsByNickname(nickname) > 0;
    }
}
