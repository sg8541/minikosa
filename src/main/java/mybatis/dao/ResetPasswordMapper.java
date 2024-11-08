package mybatis.dao;

import com.kosa.mini.domain.member.ResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ResetPasswordMapper {

    @Select("SELECT member_id, name, email, nickname, password, role_id, phone_number, created_at FROM members WHERE name = #{name} AND phone_number = #{phoneNumber} AND email = #{email}")
    ResetPasswordDTO searchMember(String name, String phoneNumber, String email);

    @Update("UPDATE members SET password = #{newPassword} WHERE email = #{email}")
    int updatePassword(String newPassword, String email);
}
