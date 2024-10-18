package com.kosa.mini.service.member;
import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.domain.member.Member;
import mybatis.dao.EditProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditProfileServiceImpl implements EditProfileService {

    @Autowired
    private EditProfileMapper editProfileMapper;

    public EditProfileServiceImpl(EditProfileMapper editProfileMapper) {
        this.editProfileMapper = editProfileMapper;
    }

    @Override
    public EditProfileDTO getMemberById(Long memberId) {
        return editProfileMapper.findById(memberId);
    }
    @Override
    public void updateMember(Member member) {
        editProfileMapper.updateMember(member);
    }
    @Override
    public boolean isNicknameExists(String nickname) {
        return editProfileMapper.existsByNickname(nickname) > 0;
    }
}
