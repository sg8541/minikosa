package mybatis.dao;

import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.domain.member.UserInfoDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EditProfileMapper {
    @Select("SELECT memberId, name, email, nickname, roleId FROM MEMBERS WHERE memberId=#{memberId}")
    public int getUserInfo(UserInfoDTO dto);            // 세션(로그인값)db값

    @Select("SELECT name, nickname, email, phoneNumber, password FROM MEMBERS WHERE email = #{email}")
   public int getEditProfileByEmail(EditProfileDTO dto);  // 수정할 때 제공되는 회원정보조회 db값

    @Update("UPDATE MEMBERS " +
            "SET name = #{name}, " +
            "nickname = #{nickname}, " +
            "phone_number = #{phoneNumber}, " +
            "password = #{password} " +
            "WHERE email = #{email}")
   int updateUserProfile(EditProfileDTO dto);

    @Select("SELECT COUNT(*) FROM members WHERE nickname = #{nickname}")
    int existsByNickname(@Param("nickname") String nickname);
}
