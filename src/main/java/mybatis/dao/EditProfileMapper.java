package mybatis.dao;

import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.domain.member.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EditProfileMapper {

    @Select("SELECT * FROM members WHERE member_id = #{memberId}")
    EditProfileDTO findById(@Param("memberId") Long memberId);

    @Update({
            "<script>",
            "UPDATE members",
            "<set>",
            "<if test='name != null'>name = #{name},</if>",
            "<if test='nickname != null'>nickname = #{nickname},</if>",
            "<if test='phoneNumber != null'>phone_number = #{phoneNumber},</if>",
            "<if test='password != null'>password = #{password},</if>",
            "</set>",
            "WHERE member_id = #{memberId}",
            "</script>"
    })
    void updateMember(Member member);

    @Select("SELECT COUNT(*) FROM members WHERE nickname = #{nickname}")
    int existsByNickname(@Param("nickname") String nickname);
}
